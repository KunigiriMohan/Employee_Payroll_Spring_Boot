package com.application.EmployeePayrollApp.DTO;


import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
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
    
    @Pattern(regexp="male|female",message = "Gender needs to be male or female")
    public String gender;
    
    @JsonFormat(pattern = "dd MM yyy")
    @NotNull(message = "StartDate should not Empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    public LocalDate startDate;
    
    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;

    @NotNull(message = "department should Not be Empty")
    public List<String> department;
}
