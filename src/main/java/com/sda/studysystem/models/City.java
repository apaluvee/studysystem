package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * City model
 *
 * @author Alar
 */

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private boolean isActive;
    @OneToOne
    private County county;
    @OneToOne
    private Country country;
}
