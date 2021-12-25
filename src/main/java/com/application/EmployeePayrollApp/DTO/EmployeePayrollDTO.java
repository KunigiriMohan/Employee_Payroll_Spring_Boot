package com.application.EmployeePayrollApp.DTO;

public class EmployeePayrollDTO {
    public String name;
    public long salary;
    
    /**
     * Defining Constructer
     * @param name
     * @param salary
     */
    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
