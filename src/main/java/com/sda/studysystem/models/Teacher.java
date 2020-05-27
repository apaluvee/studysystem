package com.sda.studysystem.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Teacher model
 *
 * @author Alar
 */

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
    private boolean isActive;
    @OneToOne
    private School school;
    @OneToMany
    private List<SpecializedField> specialistFields;

}
