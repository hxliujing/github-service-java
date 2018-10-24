/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.controller;

import com.javens.java.service.EmployeeService;

/**
 *
 * @author liujing01
 * @version EmployeeController.java, v 0.1 2018-10-23 23:11 
 */
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public int getProjectedEmployeeCount(){
        final int actualEmployeeCount = employeeService.getEmployeeCount();
        return (int)Math.ceil(actualEmployeeCount * 1.2);
    }

    public void saveEmployee(Employee employee){

        employeeService.saveEmployee(employee);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeService.findEmployeeByEmail(email);
    }

    public boolean isEmployeeEmailAlreadyTaken(String email) {
        Employee employee = new Employee();
        return employeeService.employeeExists(employee);
    }
}
