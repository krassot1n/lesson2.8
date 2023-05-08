package com.skypro.lesson2_8.service;

import com.skypro.lesson2_8.model.Employee;
import com.skypro.lesson2_8.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    Map<String, Employee> epmployeesMap = new HashMap<>(Map.of(
            "Муратов Айадил",
            new Employee("Муратов","Айадил" ),
            "Гагуля Елена ",
            new Employee("Гагуля", "Елена")));

    public Employee add(EmployeeRequest employeeRequest) throws EmployeeAllReadyAddedException {
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName());
        if (epmployeesMap.containsKey(employee.getFullName())){
            throw new EmployeeAllReadyAddedException();
        }
        epmployeesMap.put(employeeRequest.getFullName(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (epmployeesMap.containsKey(employee.getFullName())) {
            return epmployeesMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (epmployeesMap.containsKey(employee.getFullName())){
            return epmployeesMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAllEmployee() {
        return Collections.unmodifiableCollection(epmployeesMap.values());
    }

}
