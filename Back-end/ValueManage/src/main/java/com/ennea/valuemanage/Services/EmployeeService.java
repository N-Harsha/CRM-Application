package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.API.v1.DTO.CustomerDTO;
import com.ennea.valuemanage.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface EmployeeService {
    public Employee save(Employee employee);
    public Page<CustomerDTO> getCustomers(Long id, PageRequest pageRequest);

}
