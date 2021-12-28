package com.application.EmployeePayrollApp.model;

import java.time.LocalDate;
import java.util.List;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import lombok.Data;


/**
 * @Data : Using Lombok to Generate getters and setters
 * @GeneratedValue : To auto generate i value
 */
public @Data class EmployeePayrollData {
	private long id;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> department;
	/**
	 * Defining Constructer
	 * @param id
	 * @param employeePayrollDTO
	 *
	 */
	
	public EmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO){
		this.id=id;
		this.updateEmployeeDetails(employeePayrollDTO);
		
	}
	/**
	 * Constructor to define all variables from DTO object
	 * @param employeePayrollDTO
	 */
	private void updateEmployeeDetails(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary=employeePayrollDTO.salary;
		this.gender=employeePayrollDTO.gender;
		this.startDate=employeePayrollDTO.startDate;
		this.note=employeePayrollDTO.note;
		this.profilePic=employeePayrollDTO.profilePic;
		this.department=employeePayrollDTO.department;
	}
}