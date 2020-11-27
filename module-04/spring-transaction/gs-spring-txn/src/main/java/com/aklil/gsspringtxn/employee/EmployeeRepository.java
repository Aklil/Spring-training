package com.aklil.gsspringtxn.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// repository pattern simplified
// Spring JPA creates repository implementation at runtime from a repository interface
// method names follow convention // see how the IDE autocompletes method name
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    /**
     *  By extending CrudRepository, CustomerRepository inherits several methods for working with Employee persistence,
     *      including methods for saving, deleting, and finding Customer entities.
     */

    // And No need to specify methods that are on CrudRepository
    // like save, update, findById, delete etc

    // Custom methods use naming convention

    List<Employee> findByLastName(String lastName);

    List<Employee> findByFirstNameContaining(String character);

    // For complex queries and customize as however you like @Query annotation can be used
    // uses JPQL - Java Persistence Query Language
    // can also use native sql

    @Query("SELECT e FROM Employee e")  // using JPQL
    List<Employee> getAllEmployees();

    @Query(value="select * from Employee e where e.id = :id", nativeQuery = true)
    Employee getEmployeeById(@Param("id") long id);

}
