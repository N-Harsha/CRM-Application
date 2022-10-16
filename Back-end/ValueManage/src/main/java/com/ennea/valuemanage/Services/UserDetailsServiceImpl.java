package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.UserDetails;
import com.ennea.valuemanage.Repositories.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    UserDetailsRepository userDetailsRepository;

    EmployeeService employeeService;
    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository,EmployeeService employeeService) {
        this.userDetailsRepository = userDetailsRepository;
        this.employeeService=employeeService;
    }

    @Override
    public Employee getCustomer(String userName, String password) {
        Optional<Employee> optionalEmployee= userDetailsRepository.findUser(userName,password);
        return optionalEmployee.orElse(null);
    }

    public UserDetails addUser(UserDetails userDetails){
        if(userDetails.getEmployee()!=null&&userDetails.getEmployee().getId()==null){
            employeeService.save(userDetails.getEmployee());
        }
        return userDetailsRepository.save(userDetails);
    }
}
