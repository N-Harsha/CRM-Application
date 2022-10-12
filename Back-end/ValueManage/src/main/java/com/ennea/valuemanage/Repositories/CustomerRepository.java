package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
