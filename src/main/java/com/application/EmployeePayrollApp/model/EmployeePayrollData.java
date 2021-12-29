package com.application.EmployeePayrollApp.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import com.application.EmployeePayrollApp.DTO.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Data : Using Lombok to Generate getters and setters
 * @GeneratedValue : To auto generate i value
 * @Id : To Describe value as a Id in MySQL
 * @GenerateValue : To auto generate id value
 * @Column : To make that variable as a column
 * @ElementCollection : to values of department from another table employee_department
 * @CollectionTable : To connect a table to another table using Key
 * @Entity : To create class as entity
 * @Table : to Create table
 */
@Entity
@Table(name = "employee_table")
@NoArgsConstructor
@Data
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private long empId;

	@Column(name = "name")
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	
	@ElementCollection
	@CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;
	
	/**
	 * Defining Constructer
	 * @param employeePayrollDTO
	 *
	 */
	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
		this.updateEmployeeDetails(employeePayrollDTO);
	}
	/**
	 * Constructor to define all variables from DTO object
	 * @param employeePayrollDTO
	 */
	public void updateEmployeeDetails(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary=employeePayrollDTO.salary;
		this.gender=employeePayrollDTO.gender;
		this.startDate=employeePayrollDTO.startDate;
		this.note=employeePayrollDTO.note;
		this.profilePic=employeePayrollDTO.profilePic;
		this.department=employeePayrollDTO.department;
	}
}