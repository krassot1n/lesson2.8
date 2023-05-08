package com.skypro.lesson2_8.controller;

import com.skypro.lesson2_8.model.Employee;
import com.skypro.lesson2_8.record.EmployeeRequest;
import com.skypro.lesson2_8.service.EmployeeAllReadyAddedException;
import com.skypro.lesson2_8.service.EmployeeNotFoundException;
import com.skypro.lesson2_8.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employyee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.add(employeeRequest);
    }
    @GetMapping("getAll")
    public Collection<Employee> getAll(){
        return this.employeeService.getAllEmployee();
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        return this.employeeService.find(firstName,lastName);
    }@GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        this.employeeService.remove(firstName,lastName);
    }
}
