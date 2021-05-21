package com.example.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawController {

     private final EmpRepository repository;

    WithdrawController(EmpRepository repository) {
            this.repository = repository;
        }



        @RequestMapping("/withdraw")
        public BankEmp withdraw(@RequestParam(name = "withdrawAmount") Integer withdrawAmount, @RequestParam(name = "name") String name)
        {
            BankEmp customer = repository.findByUsername(name);
            customer.setTotalamt(customer.getTotalamt()- withdrawAmount);
            return customer;
        }
    }




