package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Customer;
import com.ennea.valuemanage.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select cust from Customer cust where cust.agent.id=?1")
    public Page<Customer> findAllCustomers(Long id, PageRequest pageRequest);

}
