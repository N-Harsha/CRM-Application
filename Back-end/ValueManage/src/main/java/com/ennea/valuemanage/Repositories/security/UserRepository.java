package com.ennea.valuemanage.Repositories.security;

import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findUserByUserName(String userName);
}
