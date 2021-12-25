package com.application.EmployeePayrollApp.controller;

import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.DTO.ResponseDTO;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 */

@RestController
@RequestMapping("/EmployeeDetails/")
public class EmployeePayrollController {
    /**
     * API for getting all Details of Employee
     * @return : ResonseEntity of EmployeeDetails
     */
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getEmployeeDetails(){
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Mohan", 300000));
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Getting get Employee Details by Employee ID
     * @param empID
     * @return ResponseEntity of Employee Details of given ID
     */
    @GetMapping("/get/{empID}")
    public ResponseEntity<ResponseDTO> getEmployeeDetails(@PathVariable("empID") int empID){
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Mohan", 5000000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Id : ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        
    }

    /**
     * API for Entering Employee Details in Response Entity
     * @param employeePayrollDTO
     * @return : ResponseEntity of Employee Details Data
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeeDetails(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employe Payroll Data Successfull", employeePayrollData);
        return new ResponseEntity<ResponseDTO>( responseDTO,HttpStatus.OK);
    }

    /**
     * API for Updating Details of Employee
     * @param employeePayrollDTO
     * @return : ResponseEntity of Updated Employee Details Data
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeeDetails(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data :", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Deleteing Employee by ID
     * @param empId
     * @return :ResponseEntity
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeeDetails(@PathVariable("empId") int empId){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully :  ","Deleted Id"+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}