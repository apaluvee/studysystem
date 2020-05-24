package com.sda.studysystem.controllers;

import com.sda.studysystem.models.County;
import com.sda.studysystem.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for County operations
 *
 * @author Alar
 */

@RestController
@RequestMapping("/county")
public class CountyController {
    @Autowired
    private CountyService countyService;

    @GetMapping("")
    public List<County> showAllCounties() {
        return countyService.getAllCounties();
    }

    @PostMapping("/add")
    public ResponseEntity<County> addCounty(County county) {
        countyService.createCounty(county);
        return new ResponseEntity<>(county, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<County> updateCounty(@PathVariable("id") Long countyId, County county) {
        county.setId(countyId);
        countyService.updateCounty(county);
        return new ResponseEntity<>(county, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCounty(@PathVariable("id") Long countyId) {
        countyService.deleteCountyById(countyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCounty(@PathVariable("id") Long countyId) {
        countyService.restoreCountyById(countyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


