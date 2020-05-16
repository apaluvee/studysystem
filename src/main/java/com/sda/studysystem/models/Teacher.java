package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Teacher model
 */

@Entity
@Data
public class Teacher {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String teacherId;
    private String name;
    private LocalDate joinDate;
    private boolean isActive;
    private String school;
    private String specialistFields;

}
