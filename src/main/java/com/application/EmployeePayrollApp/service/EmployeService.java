package com.application.EmployeePayrollApp.service;

import java.util.ArrayList;
import java.util.List;

import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.exceptions.EmployeePayrollException;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;

import org.springframework.stereotype.Service;


/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */

@Service
public class EmployeService implements InterfaceEmployeeservice {

    List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    /**
     * method to get employeedetails
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    /**
     * method get Employee Details by Id if Id not found Throws Exception
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream().filter(empData -> empData.getId()== empId).findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    /**
     * method to add Employee Details
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, employeePayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    /**
     * method to update Employee Details
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empID,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empID);
        employeePayrollData.setEmployeePayrollDTO(employeePayrollDTO);
        employeePayrollList.set(empID-1, employeePayrollData);

        return employeePayrollData;
    }

    /**
     * method to delete Employee Details
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
