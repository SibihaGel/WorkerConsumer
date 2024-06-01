package org.employeeservice.workprojectuchetemployee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Component
@Document(collection = "employee_card")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCard {

    private String id;
    private String fullName;

    public void setId (Employee employee) {
        id = employee.getId();
    }

    public void setFullName (Employee employee) {
        fullName = employee.getFirstname()
                + " " + employee.getLastname() + " "
                + employee.getSurname();
    }
}
