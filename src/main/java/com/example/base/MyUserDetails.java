package com.example.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetails implements UserDetailsService {
    @Autowired
    private EmpRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BankEmp customer = repo.findByUsername(username);
        if(customer==null)
            throw new UsernameNotFoundException("User 404");

        return new UserPrincipal(customer);
    }
}
