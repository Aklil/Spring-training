package com.aklil.gsmvc.employee_management;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private RestTemplate restTemplate;

    public EmployeeServiceImpl(EmployeeRepository repository, RestTemplate restTemplate){
        this.repository = repository;
        this.restTemplate = restTemplate;
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

    @Override
    public List<Object> getCountriesFromExternalApi() {
        String url = "http://api.first.org/data/v1/countries";
        Object[] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
    }

}
