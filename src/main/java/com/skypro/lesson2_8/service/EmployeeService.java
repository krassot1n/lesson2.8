package com.skypro.lesson2_8.service;

import com.skypro.lesson2_8.exceptions.EmployeeAllReadyAddedException;
import com.skypro.lesson2_8.exceptions.EmployeeNotFoundException;
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
            new Employee("Муратов", "Айадил", 95000, 1),
            "Муратова Дарига",
            new Employee("Муратова", "Дарига", 92000, 2),
            "Мухитов Жандос",
            new Employee("Мухитов", "Жандос", 98000, 3),
            "Булавка Дмитрий",
            new Employee("Булавка", "Дмитрий", 90000, 2),
            "Кайтанов Жасулан",
            new Employee("Кайтанов", "Жасулан", 99000, 3),
            "Бейсенбек Ильяс",
            new Employee("Бейсенбек", "Ильяс", 93000, 1),
            "Абашин Вячеслав",
            new Employee("Абашин", "Вячеслав", 91000, 2),
            "Идрисов Марат",
            new Employee("Идрисов", "Марат", 92000, 3),
            "Гуливец Николай",
            new Employee("Гуливец", "Николай", 97000, 2),
            "Приходько Валерий",
            new Employee("Приходько", "Валерий", 94000, 1)));

    public Employee add(EmployeeRequest employeeRequest) throws EmployeeAllReadyAddedException {
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getSalary(), employeeRequest.getDepartment());
        if (epmployeesMap.containsKey(employee.getFullName())) {
            throw new EmployeeAllReadyAddedException();
        }
        epmployeesMap.put(employeeRequest.getFullName(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (epmployeesMap.containsKey(employee.getFullName())) {
            return epmployeesMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (epmployeesMap.containsKey(employee.getFullName())) {
            return epmployeesMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAllEmployee() {
        return Collections.unmodifiableCollection(epmployeesMap.values());
    }

}
