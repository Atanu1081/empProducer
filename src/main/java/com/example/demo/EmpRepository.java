package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import https.www_howtodoinjava_com.xml.school.Employee;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmpRepository
{
    private static final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void initData()
    {
        Employee employee = new Employee();
        employee.setName("Atanu");
        employee.setTeam("Java-Microservices");
        employee.setYearOfExperience(1);
        employees.put(employee.getName(),employee);

        employee = new Employee();
        employee.setName("Karthik");
        employee.setTeam("Core");
        employee.setYearOfExperience(1);
        employees.put(employee.getName(),employee);

        employee = new Employee();
        employee.setName("Venu");
        employee.setTeam("Regression");
        employee.setYearOfExperience(1);
        employees.put(employee.getName(),employee);

        employee = new Employee();
        employee.setName("Sandeep");
        employee.setTeam("Performance");
        employee.setYearOfExperience(4);
        employees.put(employee.getName(),employee);

    }

    public Employee findEmployee (String name)
    {
        Assert.notNull(name,"Please provide a name to get Info");
        return employees.get(name);
    }

}
