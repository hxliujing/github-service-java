package com.javens.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.javens.java.controller.Employee;
import com.javens.java.controller.EmployeeController;
import com.javens.java.service.EmployeeService;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldReturnProjectedCountOfEmployeesFromTheService(){
        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);
        EmployeeController employeeController = new EmployeeController(mock);
        assertEquals(10,employeeController.getProjectedEmployeeCount());
    }

    @Test
    public void shouldInokeSaveEmployeeOnTheServiceWhileSavingTheEmployee(){
        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(mock);
        Employee employee = new Employee();
        employeeController.saveEmployee(employee);
        Mockito.verify(mock).saveEmployee(employee);
    }
}
