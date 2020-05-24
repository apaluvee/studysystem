package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Specialized Field model
 *
 * @author Alar
 */

@Entity
@Data
public class SpecializedField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @OneToOne
    private Category category;
    private boolean isActive;
}
