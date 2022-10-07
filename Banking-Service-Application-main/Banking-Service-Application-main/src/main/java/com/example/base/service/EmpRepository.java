package com.example.base.service;

import com.example.base.model.BankEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository  extends JpaRepository<BankEmp, Long> {
    @Override
    Optional<BankEmp> findById(Long aLong);

//    @Query("SELECT u FROM BankEmp u WHERE u.username =?1")
     BankEmp findByUsername(String username);

}
