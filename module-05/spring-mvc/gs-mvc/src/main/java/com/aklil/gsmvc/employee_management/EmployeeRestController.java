package com.aklil.gsmvc.employee_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employees-rest")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
      this.employeeService = employeeService;
    }

    @GetMapping(value = {"","/"})
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/countries")
    public List<Object> getCountries(){
        return employeeService.getCountriesFromExternalApi();
    }
}
