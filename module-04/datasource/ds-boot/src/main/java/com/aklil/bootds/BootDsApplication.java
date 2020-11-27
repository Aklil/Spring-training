package com.aklil.bootds;

import com.aklil.bootds.employee.Employee;
import com.aklil.bootds.employee.EmployeeReportService;
import com.aklil.bootds.employee.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class BootDsApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(BootDsApplication.class);
    @Autowired
    EmployeeReportService employeeReportService;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {

        SpringApplication.run(BootDsApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //employeeReportService.printReport();

        List<Employee> employees = employeeRepository.findEmployees();

        employees.forEach(employee ->  logger.info(employee.getFirstName() + ' ' + employee.getLastName()));
    }
}
