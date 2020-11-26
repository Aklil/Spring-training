package com.aklil.gsspringjpa.employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository){

        this.repository = repository;
    }

    public List<Employee> getEmployees(){
        return (List<Employee>)this.repository.findAll();
    }

    public void saveEmployee(Employee employee){
        this.repository.save(employee);
    }


}
