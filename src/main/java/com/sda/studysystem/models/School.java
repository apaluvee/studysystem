package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * School model
 *
 * @author Alar
 */

@Entity
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private String street;
    @OneToOne
    private City city;
    @OneToOne
    private County county;
    @OneToOne
    private Country country;
    private String zipcode;
    private boolean isActive;
}
