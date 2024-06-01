package org.employeeservice.workprojectuchetemployee.service;

import org.employeeservice.workprojectuchetemployee.DAO.EmployeeRepository;
import org.employeeservice.workprojectuchetemployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(String id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setLastname(employee.getLastname());
            existingEmployee.setFirstname(employee.getFirstname());
            existingEmployee.setSurname(employee.getSurname());
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
            existingEmployee.setStatus(employee.getStatus());
            existingEmployee.setDepartmentId(employee.getDepartmentId());
            existingEmployee.setIsOnLeave(employee.getIsOnLeave());
            existingEmployee.setIsOnSickLeave(employee.getIsOnSickLeave());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deleteEmployee(String id) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            employeeRepository.delete(existingEmployee);
            return true;
        } else {
            return false;
        }
    }


    @Transactional
    public List<Employee> searchEmployees(Boolean status, Long departmentId) {
        return employeeRepository.findByStatusAndDepartmentId (status, departmentId);
    }


    @Transactional
    public List<Employee> getEmployeesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.findByDateOfEmploymentBetween(startDate, endDate);
    }


}



