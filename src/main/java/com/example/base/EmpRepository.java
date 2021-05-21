package com.example.base;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmpRepository  extends JpaRepository<BankEmp, Long> {
    BankEmp findByUsername(String username);

}
