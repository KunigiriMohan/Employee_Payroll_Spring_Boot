package com.application.EmployeePayrollApp.service;
import java.util.List;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;
import com.application.EmployeePayrollApp.model.User;

/**
 * Interface to create methods to perform operations
 */
public interface InterfaceEmployeeservice {
    List<EmployeePayrollData> getEmployeePayrollData(/*String token*/);
    EmployeePayrollData getEmployeePayrollDataById(Long empId,String token);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollData employeePayrollDTO);
    void deleteEmployeePayrollData(Long empId/*,String token*/);
    EmployeePayrollData updateEmployeePayrollData(Long empID, EmployeePayrollDTO employeePayrollDTO,String token);
    public User createUser(User user);
    /*public String generateToken(User user);*/
}
