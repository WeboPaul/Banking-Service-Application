package com.example.base.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Bank_Emp")
public class BankEmp {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(name = "FirstName")
     private String firstName;
     @Column(name = "LastName")
     private String lastName;
     @Column(name = "Role")
     private String role;
     @Column(name = "Username")
     private String username;
     @Column(name = "Password")
     private String password;
     @Column(name = "Balance")
     private int balance;

    public BankEmp() {

    }

    public BankEmp(String firstName, String lastName, String role, String username, String password, int balance) {
        this.firstName = firstName;
        this.role = role;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }



    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;

    }
}
