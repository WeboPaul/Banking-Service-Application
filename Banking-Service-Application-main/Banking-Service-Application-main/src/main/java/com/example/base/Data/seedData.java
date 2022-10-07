package com.example.base.Data;

import com.example.base.model.BankEmp;
import com.example.base.service.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class seedData implements CommandLineRunner {
    @Autowired
    private EmpRepository empRepository;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) throws Exception {
        BankEmp emp = new BankEmp();
        emp.setUsername("paul");
        emp.setFirstName("paul");
        emp.setLastName("webo");
        emp.setRole("user");
        emp.setPassword(passwordEncoder().encode("webo2276"));
        emp.setBalance(100);
        empRepository.save(emp);
    }
}
