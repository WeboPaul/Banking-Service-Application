package com.example.base;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.*;

@Data
@Entity
public class BankEmp {
    private @Id @GeneratedValue Long id;
    private String fname;
    private String lname;
    private String role;
    private String username;
    private String password;
    private int totalamt;

    BankEmp() {}

    BankEmp(String fname, String lname, String role, String username, String password,int totalamt) {
        this.fname = fname;
        this.role = role;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.totalamt =  totalamt;
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

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTotalamt(int totalamt) {
        this.totalamt = totalamt;
    }

    public int getTotalamt() {
        return totalamt;

    }
}
