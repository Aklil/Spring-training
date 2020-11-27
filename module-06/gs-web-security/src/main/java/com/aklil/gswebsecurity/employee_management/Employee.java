package com.aklil.gswebsecurity.employee_management;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// lombok annotations
@Getter
@Setter

// spring data jpa annotation

// @Entity - indicates a JPA entity - assumes entity is mapped to a table called 'employee'
@Entity
public class Employee {
    @Id  // JPA recognizes it as the Object's ID
    @GeneratedValue(strategy = GenerationType.AUTO)  // id is generated automatically
    private long id;

    private String firstName;   // mapped to columns in the db with the same name
    private String lastName;   // last_name

    protected Employee(){}  // used by JPA

    //constructor with args is used by the developer to create instances of employee

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format("Employee: [id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}
