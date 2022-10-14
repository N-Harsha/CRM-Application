package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.API.v1.DTO.CustomerDTO;
import com.ennea.valuemanage.API.v1.DTO.ReportDTO;
import com.ennea.valuemanage.API.v1.Mapper.CustomerMapper;
import com.ennea.valuemanage.API.v1.Mapper.EmployeeMapper;
import com.ennea.valuemanage.API.v1.Mapper.ReportMapper;
import com.ennea.valuemanage.Model.Attendance;
import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.Report;
import com.ennea.valuemanage.Repositories.AddressRepository;

import com.ennea.valuemanage.Repositories.EmployeeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;
    AddressRepository addressRepository;
    ReportService reportService;
    CustomerService customerService;
    AttendanceService attendanceService;

    EmployeeMapper employeeMapper;

    CustomerMapper customerMapper;
    ReportMapper reportMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository,
                               ReportService reportService, CustomerService customerService,
                               AttendanceService attendanceService,EmployeeMapper employeeMapper,
                                CustomerMapper customerMapper,ReportMapper reportMapper) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.reportService = reportService;
        this.customerService = customerService;
        this.attendanceService = attendanceService;
        this.employeeMapper=employeeMapper;
        this.customerMapper=customerMapper;
        this.reportMapper=reportMapper;
    }

    @Override
    public Employee save(Employee employee) {
        if(employee.getSupervisor()!=null&&employee.getSupervisor().getId()==null)
            employee.setSupervisor(save(employee.getSupervisor()));

        Employee savedEmployee=employeeRepository.save(employee);

        employee.setCustomers(employee.getCustomers()
                .stream()
                .map(customer -> {
                    customer.setAgent(savedEmployee);
                    return customer.getId() != null ? customer : customerService.save(customer);
                })
                .collect(Collectors.toSet()));

        employee.setReports(
                employee.getReports()
                        .stream()
                        .map(report -> {
                            report.setEmployee(savedEmployee);
                            return report.getId() != null ? report : reportService.save(report);
                        })
                        .collect(Collectors.toSet()));

        employee.setAttendanceList(
                employee.getAttendanceList()
                        .stream()
                        .map(attendance -> {
                            attendance.setEmployee(savedEmployee);
                            return attendance.getId() != null ? attendance : attendanceService.save(attendance);
                        })
                        .collect(Collectors.toSet()));

        return savedEmployee;
    }

    @Override
    public Page<CustomerDTO> getCustomers(Long id, PageRequest pageRequest) {
       return employeeRepository.findAllCustomers(id,pageRequest).map(customerMapper::customerToCustomerDTO);
    }

    @Override
    public List<LocalDate> getPresentDates(Long id, int month, int year) {
        return employeeRepository.findAllPresentDates(id,
                LocalDate.of(year,month,1),
                LocalDate.of((month+1)<12?year:year+1,(month+1)==13?1:(month+1),1).minusDays(1));
    }

    @Override
    public List<ReportDTO> getReports(Long id) {
        return employeeRepository.findAllReports(id).stream().map(reportMapper::reportToReportDTO).collect(Collectors.toList());
    }

    @Override
    public void markAttendance(Long id) {
        //todo add error handling code for mark attendance
        attendanceService.save(Attendance.builder().presenceDate(LocalDate.now()).employee(employeeRepository.findById(id).get()).build());
    }

    @Override
    public void submitReport(Long id, ReportDTO reportDTO) {
        //todo add error handling for report post
        Report report = reportMapper.reportDTOToReport(reportDTO);
        report.setEmployee(employeeRepository.findById(id).get());
        reportService.save(report);
    }

}
