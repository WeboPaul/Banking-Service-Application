package com.example.base;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
// end::hateoas-imports[]

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
    private final EmpRepository repository;

    EmpController(EmpRepository repository) {
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

    @RequestMapping(value={"/allCustomers"}, method = RequestMethod.GET)
    public ModelAndView allCustomers() {
        List<BankEmp> allCustomers = repository.findAll();
        ModelAndView map = new ModelAndView("Accountdetails");
        map.addObject("lists", allCustomers);
        return map;
    }

    //mapping of each request
    @RequestMapping("/")
    public String home() {
        return "main";
    }

    @RequestMapping("/logout-success")
    public String logoutSuccess() {
        return "thankyou";
    }

    @PostMapping("/employees")
    BankEmp newEmployees(@RequestBody BankEmp newCustomer) {
        return repository.save(newCustomer);
    }

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping("/logout")
    public String logoutPage()
    {
        return "logout";
    }
}
