package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Customer;
import com.ennea.valuemanage.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select cust from Customer cust where cust.agent.id=?1")
    public Page<Customer> findAllCustomers(Long id, PageRequest pageRequest);

    @Query("select attendance.presenceDate from Attendance attendance where attendance.employee.id=?1 and attendance.presenceDate between ?2 and ?3")
    List<LocalDate> findAllPresentDates(Long id, LocalDate st_date, LocalDate end_date);
}
