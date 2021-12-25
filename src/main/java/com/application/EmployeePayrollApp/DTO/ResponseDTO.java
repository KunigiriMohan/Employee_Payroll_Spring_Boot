package com.application.EmployeePayrollApp.DTO;

import lombok.Data;
/**
 * @Data : Using lombok to autogenerate toString() , Getters and Setters.
 */
public @Data class ResponseDTO {
    public String message;
    public Object data;
    
    /**
     * Defining Constructor
     * @param name
     * @param employeePayrollData
     */
    public ResponseDTO(String message, Object employeePayrollData) {
        this.message = message;
        this.data = employeePayrollData;
    }   
}
