package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.API.v1.DTO.CustomerDTO;
import com.ennea.valuemanage.API.v1.Mapper.CustomerMapper;
import com.ennea.valuemanage.API.v1.Mapper.EmployeeMapper;
import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Repositories.AddressRepository;

import com.ennea.valuemanage.Repositories.EmployeeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository,
                               ReportService reportService, CustomerService customerService,
                               AttendanceService attendanceService,EmployeeMapper employeeMapper,
                                CustomerMapper customerMapper) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.reportService = reportService;
        this.customerService = customerService;
        this.attendanceService = attendanceService;
        this.employeeMapper=employeeMapper;
        this.customerMapper=customerMapper;
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
}
