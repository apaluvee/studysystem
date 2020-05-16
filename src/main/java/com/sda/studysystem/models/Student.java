package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Student model
 */

@Entity
@Data
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String studentId;
    private String name;
    private LocalDate joinDate;
    private boolean isActive;
    private String school;
    private String specialistFields;
}
