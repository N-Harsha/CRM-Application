package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
