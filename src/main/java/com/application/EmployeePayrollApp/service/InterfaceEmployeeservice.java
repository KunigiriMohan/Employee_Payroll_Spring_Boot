package com.application.EmployeePayrollApp.service;
import java.util.List;

import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;

/**
 * Interface to create methods to perform operations
 */
public interface InterfaceEmployeeservice {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayrollData(int empId);
}
