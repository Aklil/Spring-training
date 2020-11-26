package com.aklil.gsspringjpa;

import com.aklil.gsspringjpa.employee.Employee;
import com.aklil.gsspringjpa.employee.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GsSpringJpaApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(GsSpringJpaApplication.class);

	@Autowired
	EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(GsSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("=== save employees");
		repository.save(new Employee("Jack", "Bauer"));
		repository.save(new Employee("Mat", "Damon"));

		logger.info("=== fetching all employees");
		List<Employee> employees = (List<Employee>) repository.findAll();

		employees.forEach(employee -> logger.info(employee.toString()));


		//logger.info(repository.getEmployeeById(1).toString());
	}
}
