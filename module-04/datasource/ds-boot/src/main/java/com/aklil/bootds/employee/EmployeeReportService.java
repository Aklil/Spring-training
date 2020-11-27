package com.aklil.bootds.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("Employees List");
        employeeRepository.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employees Average Salary Calculated Row by Row");
        System.out.println(employeeRepository.findAverageSalaryRowByRow());

        System.out.println("Employees Average Salary Calculated on Entire Result Set");
        System.out.println(employeeRepository.findAverageSalaryCalculatedOnEntireResultSet());

        System.out.println("Employees Average Salary with streams");
        System.out.println(employeeRepository.findAverageSalaryModernImplementation());

        System.out.println("Employees Average Salary sql level");
        System.out.println(employeeRepository.findAverageSalarySqlLevel());

        System.out.println("Employee found based on email");
        System.out.println(employeeRepository.findEmployeeIdFromEmail("Jayvon.Grant@corp.com"));

        System.out.println("Employee Report Stop");
    }
}
