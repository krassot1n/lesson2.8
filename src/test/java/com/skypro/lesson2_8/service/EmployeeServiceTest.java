package com.skypro.lesson2_8.service;

import com.skypro.lesson2_8.exceptions.EmployeeAllReadyAddedException;
import com.skypro.lesson2_8.exceptions.EmployeeNotFoundException;
import com.skypro.lesson2_8.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();


    @Test
    public void testAddNewEmployee() {
        Employee expected = new Employee("Муратова", "Дарига", 92000, 2);
        Employee actual = employeeService.addEmployee("Муратова", "Дарига", 92000, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThrowsEmployeeAllReadyAddedException() {
        Employee test = employeeService.addEmployee("Муратова", "Дарига", 92000, 2);
        Assertions.assertThrows(EmployeeAllReadyAddedException.class, () -> employeeService.addEmployee("Муратова", "Дарига", 92000, 2));
    }

    @Test
    public void testRemoveEmployee() {
        employeeService.addEmployee("Муратова", "Дарига", 92000, 2);
        employeeService.remove("Муратова", "Дарига", 92000, 2);
        Assertions.assertFalse(employeeService.getAllEmployee().contains("Муратова Дарига"));
    }

    @Test
    public void testThrowsEmployeeNotFoundException() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("Муратова", "Дарига", 92000, 2));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("Муратова", "Дарига", 92000, 2));
    }

    @Test
    public void testFindEmployee() {
        Employee expected = employeeService.addEmployee("Ivanov", "Ivan", 1000, 1);
        Employee actual = employeeService.find("Ivanov", "Ivan", 1000, 1);
        Assertions.assertEquals(expected, actual);

    }
}