package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    public Optional<Employee> findByUserName(String username);
}
