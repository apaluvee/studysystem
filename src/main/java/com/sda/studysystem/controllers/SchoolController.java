package com.sda.studysystem.controllers;


import com.sda.studysystem.models.City;
import com.sda.studysystem.models.School;
import com.sda.studysystem.models.Country;
import com.sda.studysystem.models.County;
import com.sda.studysystem.services.CityService;
import com.sda.studysystem.services.SchoolService;
import com.sda.studysystem.services.CountryService;
import com.sda.studysystem.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for School operations
 *
 * @author Alar
 */

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("")
    public List<School> showAllSchools() {
        return schoolService.getAllSchools();
    }

    @PostMapping("/add")
    public ResponseEntity<School> addSchool(School school) {
        schoolService.createSchool(school);
        return new ResponseEntity<>(school, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable("id") Long schoolId, School school) {
        school.setId(schoolId);
        schoolService.updateSchool(school);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable("id") Long schoolId) {
        schoolService.deleteSchoolById(schoolId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreSchool(@PathVariable("id") Long schoolId) {
        schoolService.restoreSchoolById(schoolId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


