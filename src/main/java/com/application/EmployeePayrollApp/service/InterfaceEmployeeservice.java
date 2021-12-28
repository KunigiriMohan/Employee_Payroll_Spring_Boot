package com.application.EmployeePayrollApp.service;
import java.util.List;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;

/**
 * Interface to create methods to perform operations
 */
public interface InterfaceEmployeeservice {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(Long empId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayrollData(Long empId);
    EmployeePayrollData updateEmployeePayrollData(Long empID, EmployeePayrollDTO employeePayrollDTO);
    List<EmployeePayrollData> getEmployeesByDepartment(String department);
}
