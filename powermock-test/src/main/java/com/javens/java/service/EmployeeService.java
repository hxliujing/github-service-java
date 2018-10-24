/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.service;

import com.javens.java.controller.Employee;
import com.javens.java.controller.EmployeeIdGenerator;
import com.javens.java.controller.WelcomeEmail;

/**
 *
 * @author liujing01
 * @version EmployeeService.java, v 0.1 2018-10-23 23:12 
 */
public class EmployeeService {
    public int getEmployeeCount() {
        //throw  new UnsupportedOperationException();
        return Employee.count();
    }

    public void saveEmployee(Employee employee) {
        //throw new UnsupportedOperationException();
        if(employee.isNew()){
            employee.setEmployeeId(EmployeeIdGenerator.getNextId());
            employee.create();
            WelcomeEmail emailSender = new WelcomeEmail(employee,
                    "Welcome to Mocking with PowerMock How-to!");
            emailSender.send();
            return;
        }
        employee.update();
    }

    public void saveEmployee2(Employee employee) {
        if(employee.isNew()) {
            createEmployee(employee);
            return;
        }
        employee.update();
    }

    private void createEmployee(Employee employee) {
        employee.setEmployeeId(EmployeeIdGenerator.getNextId());
        employee.create();
        WelcomeEmail emailSender = new WelcomeEmail(employee,
                "Welcome to Mocking with PowerMock How-to!");
        emailSender.send();
    }

    public boolean giveIncrementToAllEmployeesOf(int percentage){
        try{
            Employee.giveIncrementOf(percentage);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Employee findEmployeeByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    public boolean employeeExists(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
