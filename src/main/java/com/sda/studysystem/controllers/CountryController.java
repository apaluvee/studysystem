package com.sda.studysystem.controllers;


import com.sda.studysystem.models.Country;
import com.sda.studysystem.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public String showAllCountries(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "show-all-countries";
    }

    @GetMapping("/add")
    public String addCountryForm(Model model) {
        return "add-country";
    }

    @PostMapping("/add")
    public String addCountry(Country country, Model model) {
        country.setActive(true);
        boolean createResult = countryService.createCountry(country);

        if (createResult) {
            model.addAttribute("message", "Country has been successfully created");
            model.addAttribute("messageType", "success");
            return showAllCountries(model);
        } else {
            model.addAttribute("country", country);
            model.addAttribute("message", "Error in creating a country");
            model.addAttribute("messageType", "error");
            return addCountryForm(model);
        }
    }

    @GetMapping("/update")
    public String updateCountryForm(Model model) {
        return "update-country";
    }

    @PostMapping("/update/{id}")
    public String updateCountry(@PathVariable("id") Long countryId, Country country, Model model) {
        country.setId(countryId);
        boolean updateResult = countryService.updateCountry(country);

        if (updateResult) {
            model.addAttribute("message", "Country has been successfully updated");
            model.addAttribute("messageType", "success");
            return showAllCountries(model);
        } else {
            model.addAttribute("country", country);
            model.addAttribute("message", "Error in updating a country");
            model.addAttribute("messageType", "error");
            return updateCountryForm(model);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable("id") Long countryId, Model model) {
        boolean deleteResult = countryService.deleteCountryById(countryId);

        if (deleteResult) {
            model.addAttribute("message", "Country has been successfully deleted");
            model.addAttribute("messageType", "success");

        } else {
            model.addAttribute("message", "Error in deleting a country");
            model.addAttribute("messageType", "error");
        }
        return showAllCountries(model);
    }

    @GetMapping("/restore/{id}")
    public String restoreCountry(@PathVariable("id") Long countryId, Model model) {
        boolean restoreResult = countryService.restoreCountryById(countryId);

        if (restoreResult) {
            model.addAttribute("message", "Country has been successfully restored");
            model.addAttribute("messageType", "success");

        } else {
            model.addAttribute("message", "Error in restoring a country");
            model.addAttribute("messageType", "error");
        }
        return showAllCountries(model);
    }

}
