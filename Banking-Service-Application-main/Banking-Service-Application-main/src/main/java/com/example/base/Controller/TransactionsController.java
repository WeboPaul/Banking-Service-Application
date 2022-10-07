package com.example.base.Controller;

import com.example.base.model.BankEmp;
import com.example.base.service.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TransactionsController {
    @Autowired
    private EmpRepository repository;

    @GetMapping("/withdraw/{id}")
    public String withdraw(@PathVariable("id") Long id, Model model){

        Optional<BankEmp> optionalBankEmp = repository.findById(id);
        if (optionalBankEmp.isPresent()){
            BankEmp emp = optionalBankEmp.get();
            model.addAttribute("withdraw",emp);
            return "withdraw";
        }else {
            return null;
        }
    }
    @GetMapping("/deposit/{id}")
    public String deposit(@PathVariable("id") Long id,Model model){
        Optional<BankEmp> optionalBankEmp = repository.findById(id);
        if (optionalBankEmp.isPresent()){
            BankEmp emp = optionalBankEmp.get();
            model.addAttribute("deposit",emp);
            return "deposit";
        }else {
            return null;
        }
    }

    @PostMapping("/withdraw")
    public String withdrawValidation(@ModelAttribute BankEmp emp,@PathVariable("id")Long id){
        Optional<BankEmp> optionalBankEmp = repository.findById(id);
        if (optionalBankEmp.isPresent()){
            BankEmp emp1 = optionalBankEmp.get();
            emp1.setBalance(emp1.getBalance() - emp.getBalance());
            repository.save(emp1);
            return "viewAsList";
        }
        return null;
    }
    @PostMapping("/deposit")
    public String depositValidation(@PathVariable("id") Long id, @ModelAttribute BankEmp emp){
        Optional<BankEmp> optionalBankEmp = repository.findById(id);
        if (optionalBankEmp.isPresent()){
            BankEmp emp1 = optionalBankEmp.get();
            emp1.setBalance(emp1.getBalance() - emp.getBalance());
            repository.save(emp1);
            return "viewAsList";
        }
        return null;
    }
}
