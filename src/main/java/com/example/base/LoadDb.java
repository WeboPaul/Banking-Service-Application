package com.example.base;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
@Slf4j
public class LoadDb {
    @Bean
    CommandLineRunner initDatabase(EmpRepository repository) {
        return args -> {
            repository.save(new BankEmp("James", "Smith", "manager","james","***",100));
             repository.save(new BankEmp("Audrey"," Jason", "thief","audrey","*****",200));
            repository.save(new BankEmp("Sonal", "yadav","customer","sonal","****",300));
        };
    }
}
