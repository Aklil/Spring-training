package com.aklil.gswebsecurity.employee_management;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>)repository.findAll();
    }

    @Override
    public void createOrUpdate(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }

}
