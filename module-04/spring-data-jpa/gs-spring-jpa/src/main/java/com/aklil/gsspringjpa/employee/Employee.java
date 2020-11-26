package com.aklil.gsspringjpa.employee;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<Account> accounts;

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
