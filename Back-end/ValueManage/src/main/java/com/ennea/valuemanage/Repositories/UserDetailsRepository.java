package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    @Query("select user.employee from UserDetails user where user.userName=?1 and user.password=?2")
    public Optional<Employee> findUser(String userName,String password);

}
