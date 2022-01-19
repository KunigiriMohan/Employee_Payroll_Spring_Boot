package com.application.EmployeePayrollApp.service;

import java.util.List;
import java.util.Optional;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import com.application.EmployeePayrollApp.exceptions.EmployeePayrollException;
import com.application.EmployeePayrollApp.model.EmployeePayrollData;
import com.application.EmployeePayrollApp.model.User;
import com.application.EmployeePayrollApp.repository.EmployeePayrollRepository;
import com.application.EmployeePayrollApp.repository.UserRepository;
import com.application.EmployeePayrollApp.utility.JwtTokenUtil;
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

    /**
     * Autowiring EmployeePayrollRepository for dependency Injection
     */
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    /**
     * Autowiring UserRepository for Dependency Injection to save in DB
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Autowiring JwtTokenUtil
     */
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    
    /**
     * method to get employeedetails
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData(String token) {
        if (jwtTokenUtil.isValidToken(token)){
            return employeePayrollRepository.findAll();
        }
        else throw new EmployeePayrollException("User Not Found");
    }

    /**
     * method get Employee Details by Id if Id not found Throws Exception
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(Long empId,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            return employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        }
        else throw new EmployeePayrollException("User Not Found");
    }

    /**
     * method to add Employee Details
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            EmployeePayrollData employeePayrollData = new EmployeePayrollData( employeePayrollDTO);
            log.debug("Employee Data : "+employeePayrollData.toString());
            return employeePayrollRepository.save(employeePayrollData);
        }
        else throw new EmployeePayrollException("User Not Found"); 
    }

    /**
     * method to update Employee Details
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(Long empID,EmployeePayrollDTO employeePayrollDTO,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empID,token);
            employeePayrollData.updateEmployeeDetails(employeePayrollDTO);
            return employeePayrollRepository.save(employeePayrollData);
        }
        else throw new EmployeePayrollException("User Not Found");
    }

    /**
     * method to delete Employee Details
     */
    @Override
    public void deleteEmployeePayrollData(Long empId,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            employeePayrollRepository.deleteById(empId);
        }
        else throw new EmployeePayrollException("User Not Found");
    }

    /**
     * implementing method cretingUser in DB
     */
    @Override
    public User createUser(User user){
        if(userRepository.findAll().size()==0){
            return userRepository.save(user);
        }
        else{
            User userDetails=userRepository.getUserDetails(user.getUserName() ,user.getPassWord());
            if(userDetails==null){
                return userRepository.save(user);
        }
            else{
                throw new EmployeePayrollException("User Already Present");
            }
        }  
    }

    /**
     * implementing method generatingToken 
     */
    @Override
    public String generateToken(User user) {
        Optional<User> userOptional = userRepository.findById(userRepository.getUserDetails(user.getUserName() ,user.getPassWord()).getID());
        if(userOptional.isPresent()){

            return jwtTokenUtil.generateToken(user.getUserName());
        }
        else{
            throw new EmployeePayrollException("User Not Found");
        }   
    } 
}