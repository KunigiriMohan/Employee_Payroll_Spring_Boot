package com.application.EmployeePayrollApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * @SpringBootApplication : main application class
 * @Slf4j : Using lombok for log message.
 */
@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {	
	public static void main(String[] args) {
		ApplicationContext contex = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		//log.info("Employee Payroll App Started  {} in Environment", contex.getEnvironment().getProperty("environment"));
		//log.info("Employee Payroll DB User id {} ", contex.getEnvironment().getProperty("spring.datasource.username"));
	}
}
