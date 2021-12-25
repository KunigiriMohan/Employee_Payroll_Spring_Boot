package com.application.EmployeePayrollApp.model;

import javax.persistence.GeneratedValue;

import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {
	@GeneratedValue
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
}
