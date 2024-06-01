package org.employeeservice.workprojectuchetemployee.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Component
@Document(collection = "employee")
@NoArgsConstructor
@Setter
public class Employee {

    @Id
    @Field("_id")
    private String id = UUID.randomUUID().toString();
    private String jobTitle; // занимаемая должность
    private String firstname;
    private String lastname;
    private String surname;
    private LocalDate dateOfBirth;
    private String profession; // профессия
    private Boolean isFamilyStatus; // семейное положение
    private Boolean status; // действующий работник
    private LocalDate dateOfEmployment;
    private Long departmentId;
    private LocalDate dateOfEmploymentOnDepartment;
    private Boolean isOnLeave; // в отпуске
    private LocalDate startOnLeave;
    private LocalDate endOnLeave;
    private Boolean isOnSickLeave; // на больничном
    private LocalDate startSickLeave;
    private LocalDate endOnSickLeave;
    private int shiftsMonth; // количество смен

    @Builder
    public Employee(String id, String jobTitle, String firstname, String lastname, String surname, LocalDate dateOfBirth, String profession, Boolean isFamilyStatus, Boolean status, LocalDate dateOfEmployment, Long departmentId, LocalDate dateOfEmploymentOnDepartment, Boolean isOnLeave, LocalDate startOnLeave, LocalDate endOnLeave, Boolean isOnSickLeave, LocalDate startSickLeave, LocalDate endOnSickLeave, int shiftsMonth) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.profession = profession;
        this.isFamilyStatus = isFamilyStatus;
        this.status = status;
        this.dateOfEmployment = dateOfEmployment;
        this.departmentId = departmentId;
        this.dateOfEmploymentOnDepartment = dateOfEmploymentOnDepartment;
        this.isOnLeave = isOnLeave;
        this.startOnLeave = startOnLeave;
        this.endOnLeave = endOnLeave;
        this.isOnSickLeave = isOnSickLeave;
        this.startSickLeave = startSickLeave;
        this.endOnSickLeave = endOnSickLeave;
        this.shiftsMonth = shiftsMonth;
    }
}
