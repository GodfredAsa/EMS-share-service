package com.employee.employeedemo.service.impl;

import com.employee.employeedemo.exception.EmployeeNotFoundException;
import com.employee.employeedemo.model.Employee;
import com.employee.employeedemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with %s not found", id)));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = findEmployeeById(id);
         employees.remove(employee);
         return String.format("Employee with ID: %s successfully  deleted", employee.getEmployeeId());
    }

    public Employee findEmployeeById(String id){
       return employees.stream()
                .filter(e -> e.getEmployeeId().equals(id))
                .findFirst()
                .get();
    }

}
