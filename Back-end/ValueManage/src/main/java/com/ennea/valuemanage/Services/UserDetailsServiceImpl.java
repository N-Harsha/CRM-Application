package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.Model.Employee;
import com.ennea.valuemanage.Model.UserDetails;
import com.ennea.valuemanage.Repositories.UserDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

//    @Override
//    public Employee getCustomer(String userName, String password) {
//        UserDetails
//    }
}
