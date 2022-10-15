package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Employee;

public interface UserDetailsService {
    public Employee getCustomer(String userName,String password);
}
