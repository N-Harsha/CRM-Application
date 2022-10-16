package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.UserDetails;

public interface UserDetailsService {
    public Employee getCustomer(String userName,String password);
    public UserDetails addUser(UserDetails userDetails);
}
