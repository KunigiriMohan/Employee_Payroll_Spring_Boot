package com.application.EmployeePayrollApp.repository;

import com.application.EmployeePayrollApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{

    /**
     * Method to Check whether User is present or not
     * @param userName
     * @param passWord
     * @return : User Object
     */
    @Query("select user from User user where user.userName=:name or user.passWord=:pass")
    public User getUserDetails(@Param("name") String userName, @Param("pass") String passWord);
}
