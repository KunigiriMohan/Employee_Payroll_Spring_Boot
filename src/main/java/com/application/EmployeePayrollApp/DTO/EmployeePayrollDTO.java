package com.application.EmployeePayrollApp.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
/**
 * @Min : To set minimum value of variable
 * @Valid :To check entered variable is valid or not
 */
public class EmployeePayrollDTO {
    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee name is Invalid")
    public String name;

    @Min(value =500,message = "Min Wage Should be more than 500")
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
