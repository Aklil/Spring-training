package com.aklil.standalone.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void printReport() {
        System.out.println("Employee Report Start");

        employeeRepository.findEmployeeEmails()
                .forEach(System.out::println);

        System.out.println("Employee Report Stop");
    }
}
