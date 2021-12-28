package com.application.EmployeePayrollApp.DTO;


import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;


/**
 * @Min : To set minimum value of variable
 * @Valid :To check entered variable is valid or not
 * @JsonFormat : to define date format
 */

public @ToString class EmployeePayrollDTO {
    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee name is Invalid")
    public String name;

    @Min(value =500,message = "Min Wage Should be more than 500")
    public long salary;
    public String gender;
    @JsonFormat(pattern = "dd MM yyy")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;
}
