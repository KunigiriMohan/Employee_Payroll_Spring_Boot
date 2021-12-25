package com.application.EmployeePayrollApp.model;

import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;

public class EmployeePayrollData {

	private long id;
    private EmployeePayrollDTO employeePayrollDTO;

	/**
	 * Defining Constructer
	 * @param id
	 * @param employeePayrollDTO
	 *
	 */
	
	public EmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO){
		this.id=id;
		this.employeePayrollDTO=employeePayrollDTO;
	}

	/**
	 * Getters and Setters
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EmployeePayrollDTO getEmployeePayrollDTO() {
		return employeePayrollDTO;
	}

	public void setEmployeePayrollDTO(EmployeePayrollDTO employeePayrollDTO) {
		this.employeePayrollDTO = employeePayrollDTO;
	}
	
}
