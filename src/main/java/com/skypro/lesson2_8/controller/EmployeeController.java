package com.skypro.lesson2_8.controller;

import com.skypro.lesson2_8.model.Employee;
import com.skypro.lesson2_8.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("firstName") String lastName,
                      @RequestParam("salary") int salary,
                      @RequestParam("dept") int dept) {
//        es.addEmployee(name, salary, dept);
        return "<h1>Сотрудник " + employeeService.addEmployee(firstName, lastName, salary, dept) + " добавлен</h1>";
    }

    @GetMapping("getAll")
    public Collection<Employee> getAll() {
        return this.employeeService.getAllEmployee();
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int salary,
                                 @RequestParam int department) {
        return this.employeeService.find(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam int salary,
                               @RequestParam int department) {
        this.employeeService.remove(firstName, lastName, salary, department);
    }
}
