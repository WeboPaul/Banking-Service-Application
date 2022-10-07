package com.example.base.security;

import com.example.base.model.BankEmp;
import com.example.base.service.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class MyUserDetails implements UserDetailsService {
    @Autowired
    private EmpRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BankEmp customer = repo.findByUsername(username);
        if(customer == null) {
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(customer);
    }
}
