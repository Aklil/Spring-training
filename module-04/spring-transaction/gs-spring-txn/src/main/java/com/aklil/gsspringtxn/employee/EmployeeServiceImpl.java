package com.aklil.gsspringtxn.employee;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeServiceImpl {

    @Transactional(isolation = Isolation.DEFAULT)
    public void save(){}
}
