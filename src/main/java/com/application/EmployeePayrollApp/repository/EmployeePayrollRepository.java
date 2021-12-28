package com.application.EmployeePayrollApp.repository;
import com.application.EmployeePayrollApp.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @Repository : Repository Interface
 * EmployeePayrollRepository to create repository of JpaRepository
 */
@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer>{
    
}
