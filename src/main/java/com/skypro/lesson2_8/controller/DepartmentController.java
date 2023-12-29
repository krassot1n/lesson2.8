package com.skypro.lesson2_8.controller;

import com.skypro.lesson2_8.model.Employee;
import com.skypro.lesson2_8.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @GetMapping("{id}/salary/max")
    public Employee maxSalary(@PathVariable("id") int id) {
        return service.max(id);
    }

    @GetMapping("{id}/salary/min")
    public Employee minSalary(@PathVariable("id") int id) {
        return service.min(id);
    }

    @GetMapping(value = "{id}/employees")
    public Collection<Employee> allByDept(@PathVariable("id") int id) {
        return service.allByDept(id);
    }

    @GetMapping(value = "/employees")
    public Map<Integer, List<Employee>> all() {
        return service.all();
    }

    @GetMapping("{id}/salary/sum")
    public int sumByDept(@PathVariable("id") int id) {
        return service.sumSalary(id);
    }
}
