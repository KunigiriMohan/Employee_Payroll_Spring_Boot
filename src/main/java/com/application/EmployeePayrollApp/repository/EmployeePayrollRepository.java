package com.application.EmployeePayrollApp.repository;

import java.util.List;
import com.application.EmployeePayrollApp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @Repository : Repository Interface
 * EmployeePayrollRepository to create repository of JpaRepository
 */
@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Long>{
    @Query (value = "select * from employee_table , employee_department where employee_id = id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}
