package com.skypro.lesson2_8.record;

public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
