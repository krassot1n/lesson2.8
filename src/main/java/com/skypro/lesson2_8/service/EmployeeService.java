package com.skypro.lesson2_8.service;

import com.skypro.lesson2_8.model.Employee;
import com.skypro.lesson2_8.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    Map<String, Employee> epmployeesMap = new HashMap<>(Map.of(
            "Муратов Айадил",
            new Employee("Муратов","Айадил" ),
            "Петрова Елена ",
            new Employee("Петрова", "Елена")));

    public Employee add(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName());
        this.epmployeesMap.put(employeeRequest.getFirstName() + " " + employeeRequest.getLastName(), employee);
        return employee;
    }

    public void remove(String firstName, String lastName) {
        if (epmployeesMap.containsKey(firstName + " " + lastName)) {
            epmployeesMap.remove(firstName + " " + lastName);
        }
    }

    public Employee find(String firstName, String lastName) {
        if (epmployeesMap.containsKey(firstName + " " + lastName)){
            return epmployeesMap.get(firstName + " " + lastName);
        }
        throw new RuntimeException("Сотрудник не найден");
    }

    public Collection<Employee> getAllEmployee() {
        return this.epmployeesMap.values();
    }

}
