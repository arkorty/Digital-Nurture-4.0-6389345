package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        Employee employee = new Employee("John", "Doe", 65000.0);
        Employee savedEmployee = employeeService.addEmployee(employee);
        System.out.println("--- Employee Saved ---");
        System.out.println(savedEmployee);
    }
}