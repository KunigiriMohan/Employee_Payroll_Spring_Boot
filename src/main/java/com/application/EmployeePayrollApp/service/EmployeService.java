package com.application.EmployeePayrollApp.service;

import java.util.List;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.exceptions.EmployeePayrollException;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;
import com.application.EmployeePayrollApp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 * @Slf4j : To Create Log
 */

@Slf4j
@Service
public class EmployeService implements InterfaceEmployeeservice {

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;
    /**
     * method to get employeedetails
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    /**
     * method get Employee Details by Id if Id not found Throws Exception
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    /**
     * method to add Employee Details
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData( employeePayrollDTO);
        log.debug("Employee Data : "+employeePayrollData.toString());
        return employeePayrollRepository.save(employeePayrollData);
    }

    /**
     * method to update Employee Details
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empID,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empID);
        employeePayrollData.updateEmployeeDetails(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    /**
     * method to delete Employee Details
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepository.deleteById(empId);
    }
}
