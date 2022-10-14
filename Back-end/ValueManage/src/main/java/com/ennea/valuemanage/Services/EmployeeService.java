package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.API.v1.DTO.CustomerDTO;
import com.ennea.valuemanage.API.v1.DTO.ReportDTO;
import com.ennea.valuemanage.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public Page<CustomerDTO> getCustomers(Long id, PageRequest pageRequest);

    List<LocalDate> getPresentDates(Long id, int month, int year);

    List<ReportDTO> getReports(Long id);
}
