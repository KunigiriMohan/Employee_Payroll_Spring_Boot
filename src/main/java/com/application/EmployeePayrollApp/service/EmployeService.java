package com.application.EmployeePayrollApp.service;

import java.util.ArrayList;
import java.util.List;

import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;

import org.springframework.stereotype.Service;


/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */

@Service
public class EmployeService implements InterfaceEmployeeservice {
    /**
     * method to get employeedetails
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        employeePayrollList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Mohan", 3000000)));
        return employeePayrollList;
    }

    /**
     * method get Employee Details by Id
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Mohan", 400000));
        return employeePayrollData;
    }

    /**
     * method to add Employee Details
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        return employeePayrollData;
    }

    /**
     * method to update Employee Details
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        return employeePayrollData;
    }

    /**
     * method to delete Employee Details
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
    }
 
}
