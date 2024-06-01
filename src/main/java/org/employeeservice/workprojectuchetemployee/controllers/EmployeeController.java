package org.employeeservice.workprojectuchetemployee.controllers;

import org.employeeservice.workprojectuchetemployee.kafka.ConsumerApi;
import org.employeeservice.workprojectuchetemployee.model.Employee;
import org.employeeservice.workprojectuchetemployee.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final ConsumerApi consumerApi;
    private final EmployeeService employeeService;

    public EmployeeController(ConsumerApi consumerApi, EmployeeService employeeService) {
        this.consumerApi = consumerApi;
        this.employeeService = employeeService;
    }

    @PostMapping("/messages")
    public List<Employee> getMessages(@RequestBody List<Employee> employees) {
        return consumerApi.getMessages();
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Employee encryptedEmployee = employeeService.getEmployeeById(id);

        if (encryptedEmployee != null) {
            // Дешифруем имя сотрудника
            String encryptedName = encryptedEmployee.getFirstname();

            String decryptedName = employeeEncryptionService.decryptEmployeeName(encryptedName);

            // Создаем новый объект Employee с дешифрованным именем
            Employee decryptedEmployee = new Employee();
          decryptedEmployee.setId(encryptedEmployee.getId());
            decryptedEmployee.setFirstname(decryptedName);
            // Устанавливаем другие свойства сотрудника

            return ResponseEntity.ok(decryptedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

   /* @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        // Шифруем данные сотрудника
        Employee encryptedEmployee = employeeEncryptionService.encryptEmployeeData(employee);

        // Сохраняем зашифрованного сотрудника в облаке
        Employee createdEmployee = employeeService.createEmployee(encryptedEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/sech/{status}/{departmentId}")
    public ResponseEntity<List<Employee>> searchEmployees(@PathVariable ("status") Boolean status,
                                                          @PathVariable ("departmentId") Long departmentId) {

        // Выполнить поиск сотрудников по указанным критериям
        List<Employee> employees = employeeService.searchEmployees(status, departmentId );

        // Вернуть список найденных сотрудников в ответе
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/data/{start}/{end}")
    public ResponseEntity <List<Employee>> searchEmployeeDataEmployment (@PathVariable ("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                         @PathVariable ("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(employeeService.getEmployeesBetweenDates(startDate, endDate));

    }
}

