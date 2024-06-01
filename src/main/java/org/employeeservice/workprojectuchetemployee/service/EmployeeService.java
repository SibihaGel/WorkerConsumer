package org.employeeservice.workprojectuchetemployee.service;

import org.employeeservice.workprojectuchetemployee.model.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(String id);

    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(String id, Employee employee);

    public boolean deleteEmployee(String id);

    public List<Employee> searchEmployees(Boolean status, Long departmentId);

    List<Employee> getEmployeesBetweenDates(LocalDate startDate, LocalDate endDate);
}
