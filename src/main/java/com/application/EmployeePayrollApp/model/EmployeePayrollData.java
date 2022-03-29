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

import lombok.AllArgsConstructor;
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
@Table(name = "employees_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String username;
	private String profile;
	private String salary;
	private String gender;
	private String day;
	private String month;
	private String year;
	private String note;
	
	
	@ElementCollection
	@CollectionTable(name = "employee_department_list",joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;

	public EmployeePayrollData(String username, String profile, String salary, String gender, String day, String month,
			String year, String note, List<String> department) {
		super();
		this.username = username;
		this.profile = profile;
		this.salary = salary;
		this.gender = gender;
		this.day = day;
		this.month = month;
		this.year = year;
		this.note = note;
		this.department = department;
	}
	
	/**
	 * Defining Constructer
	 * @param employeePayrollDTO
	 *
	 */
	/*public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
		this.updateEmployeeDetails(employeePayrollDTO);
	}*/
	/**
	 * Constructor to define all variables from DTO object
	 * @param employeePayrollDTO
	 */
	/*public void updateEmployeeDetails(EmployeePayrollDTO employeePayrollDTO) {
		this.username = employeePayrollDTO.name;
		this.salary=employeePayrollDTO.salary;
		this.gender=employeePayrollDTO.gender;
		this.startDate=employeePayrollDTO.startDate;
		this.note=employeePayrollDTO.note;
		this.profilePic=employeePayrollDTO.profilePic;
		this.department=employeePayrollDTO.department;
	}*/
}