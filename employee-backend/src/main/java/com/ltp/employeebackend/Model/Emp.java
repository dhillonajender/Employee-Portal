package com.ltp.employeebackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// The @Data annotation is a convenient shortcut that combines the functionalities of 
// @Getter, @Setter, @ToString,@EqualsAndHashCode, and @RequiredArgsConstructor annotations into a single
// annotation.
@Entity
@Data
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private Double salary;
}
