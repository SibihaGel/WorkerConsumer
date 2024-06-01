package com.example.demo.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "moving_employee")
public class movingEmployee {

    private String id;
    private String fullName;
    private LocalDate dateOfEmployment;

}
