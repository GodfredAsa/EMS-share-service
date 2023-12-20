package com.employee.employeedemo.service;
import com.employee.employeedemo.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeById(String id);
    String deleteEmployeeById(String id);
}
