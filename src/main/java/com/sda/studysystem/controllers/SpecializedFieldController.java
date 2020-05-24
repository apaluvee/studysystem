package com.sda.studysystem.controllers;

import com.sda.studysystem.models.SpecializedField;
import com.sda.studysystem.services.SpecializedFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for SpecializedField operations
 *
 * @author Alar
 */

@RestController
@RequestMapping("/specializedField")
public class SpecializedFieldController {
    @Autowired
    private SpecializedFieldService specializedFieldService;

    @GetMapping("")
    public List<SpecializedField> showAllSpecializedFields() {
        return specializedFieldService.getAllSpecializedFields();
    }

    @PostMapping("/add")
    public ResponseEntity<SpecializedField> addSpecializedField(SpecializedField specializedField) {
        specializedFieldService.createSpecializedField(specializedField);
        return new ResponseEntity<>(specializedField, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<SpecializedField> updateSpecializedField(@PathVariable("id") Long specializedFieldId, SpecializedField specializedField) {
        specializedField.setId(specializedFieldId);
        specializedFieldService.updateSpecializedField(specializedField);
        return new ResponseEntity<>(specializedField, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpecializedField(@PathVariable("id") Long specializedFieldId) {
        specializedFieldService.deleteSpecializedFieldById(specializedFieldId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreSpecializedField(@PathVariable("id") Long specializedFieldId) {
        specializedFieldService.restoreSpecializedFieldById(specializedFieldId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


