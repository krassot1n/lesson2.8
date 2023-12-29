package com.skypro.lesson2_8.service;

import com.skypro.lesson2_8.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;

    List<Employee> DATASET = List.of(new Employee("Муратов", "Айадил", 95000, 1),
            new Employee("Муратова", "Дарига", 92000, 2),
            new Employee("Мухитов", "Жандос", 98000, 3),
            new Employee("Булавка", "Дмитрий", 90000, 2),
            new Employee("Кайтанов", "Жасулан", 99000, 3),
            new Employee("Бейсенбек", "Ильяс", 93000, 1));

    @BeforeEach
    public void setUp() {
        departmentService = new DepartmentService(employeeService);
        Mockito.when(employeeService.getAllEmployee()).thenReturn(DATASET);
    }

    @Test
    void testMax() {
        var actual = departmentService.max(1);
        var expected = new Employee("Муратов", "Айадил", 95000, 1);
        assertEquals(expected, actual);

    }

    @Test
    void testMin() {
        var actual = departmentService.min(1);
        var expected = new Employee("Бейсенбек", "Ильяс", 93000, 1);
        assertEquals(expected, actual);

    }

    @Test
    void testGetAllByDept() {
        var allInFirstDept = departmentService.allByDept(1);
        assertEquals(allInFirstDept.size(), 2);
        assertIterableEquals(List.of(DATASET.get(0), DATASET.get(5)), allInFirstDept);
    }
    @Test
    void testSumByDept() {
        var sumSalaryInDept = departmentService.sumSalary(1);
        var expected = departmentService.allByDept(1).stream().mapToInt(Employee::getSalary).sum();
        assertEquals(expected, sumSalaryInDept);
    }

}
