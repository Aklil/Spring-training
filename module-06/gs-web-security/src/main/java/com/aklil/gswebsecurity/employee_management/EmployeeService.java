package com.aklil.gswebsecurity.employee_management;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Optional<Employee> getEmployeeById(long id);
    public List<Employee> getEmployees();
    public void createOrUpdate(Employee employee);

    void deleteEmployee(long id);

}
