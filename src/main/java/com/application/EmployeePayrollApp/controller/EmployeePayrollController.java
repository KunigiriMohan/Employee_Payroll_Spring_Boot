package com.application.EmployeePayrollApp.controller;

import java.util.List;
import javax.validation.Valid;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.DTO.ResponseDTO;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;
import com.application.EmployeePayrollApp.model.User;
import com.application.EmployeePayrollApp.service.InterfaceEmployeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 * @Valid : Checking Requested bean is valid or not
 */

@RestController
@CrossOrigin
@RequestMapping("/employeedetails/")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    InterfaceEmployeeservice interfaceEmployeeservice;
    /**
     * API for getting all Details of Employee
     * @return : ResonseEntity of EmployeeDetails
     */
    @GetMapping("/get")
    public /*ResponseEntity<ResponseDTO>*/ List<EmployeePayrollData> getEmployeeDetails(/*@RequestHeader String token*/){
        /*List<EmployeePayrollData> employeePayrollData = */return interfaceEmployeeservice.getEmployeePayrollData(/*token*/);
        /*ResponseDTO responseDTO = new ResponseDTO("Get call Success", employeePayrollData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);*/
    }

    /**
     * API for Getting get Employee Details by Employee ID
     * @param empID
     * @return ResponseEntity of Employee Details of given ID
     */
    @GetMapping("/get/{empID}")
    public /*ResponseEntity<ResponseDTO>*/EmployeePayrollData getEmployeeDetails(@PathVariable("empID") Long empID,@RequestHeader String token){
        /*EmployeePayrollData employeePayrollData =*/return interfaceEmployeeservice.getEmployeePayrollDataById(empID,token);
        /*ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Id : ", employeePayrollData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);*/
        
    }

    /**
     * API for Entering Employee Details in Response Entity
     * @param employeePayrollDTO
     * @return : ResponseEntity of Employee Details Data
     */
    @PostMapping("/create")
    public EmployeePayrollData addEmployeeDetails(@RequestBody EmployeePayrollData employeePayrollDTO/*,@RequestHeader String token*/){
        //log.debug("EmployeDTO : "+employeePayrollDTO.toString());
        return interfaceEmployeeservice.createEmployeePayrollData(employeePayrollDTO);
        //ResponseDTO responseDTO = new ResponseDTO("Create Employe Payroll Data Successfull", employeePayrollData, HttpStatus.OK);
        //return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Updating Details of Employee
     * @param employeePayrollDTO
     * @return : ResponseEntity of Updated Employee Details Data
     */
    @PutMapping("/update/{empID}")
    public /*ResponseEntity<ResponseDTO>*/ EmployeePayrollData updateEmployeeDetails(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO, @PathVariable ("empID") Long empID,@RequestHeader String token){
        /*EmployeePayrollData employeePayrollData =*/return interfaceEmployeeservice.updateEmployeePayrollData(empID,employeePayrollDTO,token);
        /*ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data :", employeePayrollData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);*/
    }

    /**
     * API for Deleteing Employee by ID
     * @param empId
     * @return :ResponseEntity
     */
    @DeleteMapping("/delete/{empId}")
    public /*ResponseEntity<ResponseDTO>*/void deleteEmployeeDetails(@PathVariable("empId") Long empId/*,@RequestHeader String token*/){
        interfaceEmployeeservice.deleteEmployeePayrollData( empId/*,token*/);
        /*ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully :  ","Deleted Id"+empId, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);*/
    }

    /**
     * API for Registering User 
     * @param user
     * @return : Response Entity of User Details
     */
    @PostMapping("/registeruser")
    public /*ResponseEntity<ResponseDTO>*/User generateUser(@RequestBody User user){
        /*User userDetailUser = */return interfaceEmployeeservice.createUser(user);
        /*ResponseDTO responseDTO = new ResponseDTO("Create Call Success ",userDetailUser, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);*/
    }

    /**
     * API for to LoginUser
     * @param user
     * @return : ResponseEntity of Token
     */
   /* @GetMapping("/token")
    public *//*ResponseEntity<ResponseDTO>*//*String loginUser(@RequestBody User user){
        *//*String userDetailUser =*//*return interfaceEmployeeservice.generateToken(user);
        *//*ResponseDTO responseDTO = new ResponseDTO("Create Call Success ",userDetailUser, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);*/
    }