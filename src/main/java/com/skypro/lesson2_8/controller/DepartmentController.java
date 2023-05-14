package com.skypro.lesson2_8.controller;

import com.skypro.lesson2_8.model.Employee;
import com.skypro.lesson2_8.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/dept")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return service.max(departmentId);
    }

    @GetMapping("/min- salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return service.min(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> allByDept(@RequestParam int departmentId) {
        return service.allByDept(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return service.all();
    }
}
