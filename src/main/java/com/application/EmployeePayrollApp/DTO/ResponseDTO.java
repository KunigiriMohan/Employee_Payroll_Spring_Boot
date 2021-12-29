package com.application.EmployeePayrollApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Data : Using lombok to autogenerate toString() , Getters and Setters.
 * @AllArgsContructor: To Create Constructor
 * @NoArgsConstructor : To Create No Constructor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class ResponseDTO {
    public String message;
    public Object data;  
}
