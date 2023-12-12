/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String qualification;
    private final List<Job> applicationHistory;

    public Customer(String username, String password, String role, String qualification) {
        super(username, password, role);
        this.qualification = qualification;
        this.applicationHistory = new ArrayList<>();
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<Job> getApplicationHistory() {
        return applicationHistory;
    }

    public void applyForJob(Job job) {
        applicationHistory.add(job);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role='" + getRole() + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}

