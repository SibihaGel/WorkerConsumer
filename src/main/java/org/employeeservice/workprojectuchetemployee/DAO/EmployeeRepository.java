package org.employeeservice.workprojectuchetemployee.DAO;

import org.employeeservice.workprojectuchetemployee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {


List<Employee> findByStatusAndDepartmentId (Boolean status, Long departmentId);

List<Employee> findByDateOfEmploymentBetween(LocalDate startDate, LocalDate endDate);

List<Employee> getFirstByDateOfBirthAndAndIsOnLeave(LocalDate data, Boolean isLeave);


}
