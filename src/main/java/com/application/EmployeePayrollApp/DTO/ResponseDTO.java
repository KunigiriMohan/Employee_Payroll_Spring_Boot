package com.application.EmployeePayrollApp.DTO;

public class ResponseDTO {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
       
}
