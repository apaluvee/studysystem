package com.sda.studysystem.controllers;

import com.sda.studysystem.models.City;
import com.sda.studysystem.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for City operations
 *
 * @author Alar
 */

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("")
    public List<City> showAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(City city) {
        cityService.createCity(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long cityId, City city) {
        city.setId(cityId);
        cityService.updateCity(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long cityId) {
        cityService.deleteCityById(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreCity(@PathVariable("id") Long cityId) {
        cityService.restoreCityById(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


