/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import com.javens.java.controller.Employee;
import com.javens.java.controller.EmployeeController;
import com.javens.java.controller.EmployeeIdGenerator;
import com.javens.java.controller.WelcomeEmail;
import com.javens.java.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

/**
 *
 * @author liujing01
 * @version EmployeeServiceTest.java, v 0.1 2018-10-23 23:24 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Employee.class,EmployeeIdGenerator.class,EmployeeService.class})
public class EmployeeServiceTest {

    @Test
    public void shouldReturnTheCountOfEmployeeUsingTheDomainClass(){
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.when(Employee.count()).thenReturn(900);
        EmployeeService employeeService = new EmployeeService();
        assertEquals(900,employeeService.getEmployeeCount());
    }

    @Test
    public void shouldReturnTrueWhenIncrementOf10PercentageIsGivenSuccessfully(){
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.doNothing().when(Employee.class);
        Employee.giveIncrementOf(10);
        EmployeeService employeeService = new EmployeeService();
        Assert.assertTrue(employeeService.giveIncrementToAllEmployeesOf(10));
    }
    @Test
    public void shouldReturnFalseWhenIncrementOf10PercentageIsNotGivenSuccessfully(){
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.doThrow(new IllegalStateException()).when(Employee.class);
        Employee.giveIncrementOf(10);
        EmployeeService employeeService = new EmployeeService();
        Assert.assertFalse(employeeService.giveIncrementToAllEmployeesOf(10));
    }

    @Test
    public void shouldNotDoAnythingIfEmployeeWasSaved(){
        Employee employee = PowerMockito.mock(Employee.class);
        PowerMockito.doNothing().when(employee).save();
        try{
            employee.save();
        }catch (UnsupportedOperationException e){
            fail("Should not have thrown an exception");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionIfEmployeeWasNotSaved(){
        Employee employee = PowerMockito.mock(Employee.class);
        PowerMockito.doThrow(new IllegalStateException()).when(employee).save();
        employee.save();
    }

    @Test
    public void shouldCreateNewEmployeeIfEmployeeIsNew(){
        Employee employee = PowerMockito.mock(Employee.class);
        PowerMockito.when(employee.isNew()).thenReturn(true);
        EmployeeService employeeService = new EmployeeService();
        employeeService.saveEmployee(employee);
        //Mockito.verify(mock).create()验证调用了create方法
        Mockito.verify(employee).create();
        //Mockito.verify(mock, Mockito.never()).update();验证没有调用update方法。
        Mockito.verify(employee,Mockito.never()).update();
    }

    @Test
    public void shouldInvoke_giveIncrementOfMethodOnEmployeeWhileGivingIncrement(){
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.doNothing().when(Employee.class);
        Employee.giveIncrementOf(9);
        EmployeeService employeeService = new EmployeeService();
        employeeService.giveIncrementToAllEmployeesOf(9);
        PowerMockito.verifyStatic();
        Employee.giveIncrementOf(9);
    }

    @Test
    public void shouldGenerateEmployeeIdIfEmployeeIsNew(){
        Employee mock = PowerMockito.mock(Employee.class);
        PowerMockito.when(mock.isNew()).thenReturn(true);
        PowerMockito.mockStatic(EmployeeIdGenerator.class);
        PowerMockito.when(EmployeeIdGenerator.getNextId()).thenReturn(90);
        EmployeeService employeeService = new
                EmployeeService();
        employeeService.saveEmployee(mock);
        PowerMockito.verifyStatic();
        EmployeeIdGenerator.getNextId();
        Mockito.verify(mock).setEmployeeId(90);
        Mockito.verify(mock).create();
    }

    @Test
    public void shouldSendWelcomeEmailToNewEmployees() throws Exception {
        Employee mock = PowerMockito.mock(Employee.class);
        PowerMockito.when(mock.isNew()).thenReturn(true);
        PowerMockito.mockStatic(EmployeeIdGenerator.class);
        WelcomeEmail welcomeEmailMock = PowerMockito.mock(WelcomeEmail.class);
        PowerMockito.whenNew(WelcomeEmail.class).withArguments(mock, "Welcome to Mocking with PowerMock How-to!").thenReturn(welcomeEmailMock);
        EmployeeService employeeService = new EmployeeService();
        employeeService.saveEmployee(mock);

        PowerMockito.verifyNew(WelcomeEmail.class).withArguments(mock, "Welcome to Mocking with PowerMock How-to!");
        Mockito.verify(welcomeEmailMock).send();
    }

    @Test
    public void shouldFindEmployeeByEmail(){
        final EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        final Employee employee = new Employee();
        PowerMockito.when(mock.findEmployeeByEmail(Mockito.startsWith("deep"))).thenReturn(employee);
        final EmployeeController employeeController = new EmployeeController(mock);
        assertSame(employee, employeeController.findEmployeeByEmail("deep@gitshah.com"));
        assertSame(employee, employeeController.findEmployeeByEmail("deep@packtpub.com"));
        assertNull(employeeController.findEmployeeByEmail("noreply@packtpub.com"));
    }

    @Test
    public void shouldReturnNullIfNoEmployeeFoundByEmail() {
        final EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        PowerMockito.when(mock.findEmployeeByEmail(Mockito.anyString())).thenReturn(null);
        final EmployeeController employeeController = new EmployeeController(mock);
        assertNull(employeeController.findEmployeeByEmail("deep@gitshah.com"));
        assertNull(employeeController.findEmployeeByEmail("deep@packtpub.com"));
        assertNull(employeeController.findEmployeeByEmail("noreply@packtpub.com"));
    }

    @Test
    public void shouldFindEmployeeByEmailUsingTheAnswerInterface() {

        final EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        final Employee employee = new Employee();

        PowerMockito.when(mock.findEmployeeByEmail(Mockito.anyString())).then(new Answer<Employee>() {

            public Employee answer(InvocationOnMock invocation) throws Throwable {
                final String email = (String) invocation.getArguments()[0];
                if(email == null) return null;
                if(email.startsWith("deep")) return employee;
                if(email.endsWith("packtpub.com")) return employee;
                return null;
            }
        });

        final EmployeeController employeeController = new EmployeeController(mock);
        assertSame(employee, employeeController.findEmployeeByEmail("deep@gitshah.com"));
        assertSame(employee, employeeController.findEmployeeByEmail("test@packtpub.com"));
        assertNull(employeeController.findEmployeeByEmail("hello@world.com"));
    }

    @Test
    public void shouldReturnCountOfEmployeesFromTheServiceWithDefaultAnswer() {
        EmployeeService mock = PowerMockito.mock(EmployeeService.class, new Answer() {
            public Object answer(InvocationOnMock invocation) {
                return 10;
            }
        });
        EmployeeController employeeController = new EmployeeController(mock);
        assertEquals(12, employeeController.getProjectedEmployeeCount());
    }

    @Test
    public void shouldInvokeTheCreateEmployeeMethodWhileSavingANewEmployee() throws Exception {
        final EmployeeService spy = PowerMockito.spy(new EmployeeService());
        final Employee employeeMock = PowerMockito.mock(Employee.class);
        PowerMockito.when(employeeMock.isNew()).thenReturn(true);
        PowerMockito.doNothing().when(spy,"createEmployee",employeeMock);
        spy.saveEmployee2(employeeMock);
        PowerMockito.verifyPrivate(spy).invoke("createEmployee",employeeMock);
    }

    @Test
    public void shouldGetInstanceWhiteBox(){
        //final List<Employee> employees = Whitebox.getInternalState(department, "employees");
    }

}
