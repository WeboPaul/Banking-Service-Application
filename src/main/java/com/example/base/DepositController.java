package com.example.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
     private final EmpRepository repository;

    DepositController(EmpRepository repository) {
            this.repository = repository;
        }

        // Aggregate root
        @RequestMapping("/deposit")
        public BankEmp deposit(@RequestParam(name = "depositAmount") Integer depAmount, @RequestParam(name = "name") String name)
        {
            BankEmp customer = repository.findByUsername(name);
            customer.setTotalamt(customer.getTotalamt()+ depAmount);
            return customer;
        }


    }




