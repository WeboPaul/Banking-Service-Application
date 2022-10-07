package com.example.base.Controller;


import com.example.base.service.EmpRepository;
import com.example.base.model.BankEmp;
import org.springframework.beans.factory.annotation.Autowired;

// end::hateoas-imports[]

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class EmpController {

    @Autowired
    private EmpRepository repository;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public EmpController(EmpRepository repository) {
        this.repository = repository;
    }


    // Aggregate root

    // tag::get-aggregate-root[]
//    @GetMapping("/employees")
//    Resources<Resource<BankEmp>> all() {
//
//        List<Resource<BankEmp>> employees = repository.findAll().stream()
//                .map(employee -> new Resource<>(employee,
//                        linkTo(methodOn(EmpController.class).one(employee.getId())).withSelfRel(),
//                        linkTo(methodOn(EmpController.class).all()).withRel("employees")))
//                .collect(Collectors.toList());
//
//        return new Resources<>(employees,
//                linkTo(methodOn(EmpController.class).all()).withSelfRel());
//    }
//    // end::get-aggregate-root[]
//
//    @PostMapping("/employees")
//    BankEmp newEmployee(@RequestBody BankEmp newEmployee) {
//        return repository.save(newEmployee);
//    }
//
//    // Single item
//
//    // tag::get-single-item[]
//    @GetMapping("/employees/{id}")
//    Resource<BankEmp> one(@PathVariable Long id) {
//
//        BankEmp employee = repository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException(id));
//
//        return new Resource<>(employee,
//                linkTo(methodOn(EmpController.class).one(id)).withSelfRel(),
//                linkTo(methodOn(EmpController.class).all()).withRel("employees"));
//    }
//    // end::get-single-item[]
//
//    @PutMapping("/employees/{id}")
//    BankEmp replaceEmployee(@RequestBody BankEmp newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setFname(newEmployee.getFname());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }
//
//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

    @GetMapping("/view")
    public String allCustomers(Model model) {
      model.addAttribute("users", repository.findAll());
        return "viewAsList";
    }
    @GetMapping("/view/{id}")
    public String viewStory(@PathVariable("id") Long id,Model model){
       Optional<BankEmp> bankEmp = repository.findById(id);
       if (bankEmp.isPresent()){
           BankEmp emp = bankEmp.get();
           model.addAttribute("story",emp);
           return "viewAsStory";
       }
       return null;
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id,Model model){
        Optional<BankEmp> bankEmp = repository.findById(id);
        if (bankEmp.isPresent()){
            BankEmp emp = bankEmp.get();
            model.addAttribute("story",emp);
            return "updateForm";
        }
        return null;
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,Model model){
        Optional<BankEmp> bankEmp = repository.findById(id);
        if (bankEmp.isPresent()){
            BankEmp emp = bankEmp.get();
            repository.delete(emp);
            return "redirect:/";
        }
        return null;
    }
    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute BankEmp emp){
        repository.save(emp);
        return "viewAsList";
    }

    //mapping of each request
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new BankEmp());
        return "register";
    }
    @PostMapping("/process_register")
    public String process(@ModelAttribute BankEmp emp){
        emp.setPassword(passwordEncoder().encode(emp.getPassword()));
        repository.save(emp);
        return "redirect:/";
    }
//    @RequestMapping("/logout-success")
//    public String logoutSuccess() {
//        return "redirect:/";
//    }
//
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @GetMapping("/logout")
//    public String logoutPage() {
//        return "redirect:/";
//    }
}
