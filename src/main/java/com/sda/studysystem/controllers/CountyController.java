package com.sda.studysystem.controllers;


import com.sda.studysystem.models.County;
import com.sda.studysystem.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller for County operations
 *
 * @author Alar
 */

@Controller
@RequestMapping("/county")
public class CountyController {
    @Autowired
    private CountyService countyService;

    @GetMapping("")
    public String showAllCounties(Model model) {
        List<County> counties = countyService.getAllCounties();
        model.addAttribute("counties", counties);
        return "county/county-list";
    }

    @GetMapping("/add")
    public String addCountyForm(Model model) {
        return "add-county";
    }

    @PostMapping("/add")
    public String addCounty(County county, Model model) {
        county.setActive(true);
        boolean createResult = countyService.createCounty(county);

        if (createResult) {
            model.addAttribute("message", "County has been successfully created");
            model.addAttribute("messageType", "success");
            return showAllCounties(model);
        } else {
            model.addAttribute("county", county);
            model.addAttribute("message", "Error in creating a county");
            model.addAttribute("messageType", "error");
            return addCountyForm(model);
        }
    }

    @GetMapping("/update/{id}")
    public String updateCountyForm(@PathVariable("id") Long countyId, Model model) {
        model.addAttribute("county", countyService.getById(countyId));
        return "county/county-update";
    }

    @PostMapping("/update/{id}")
    public String updateCounty(@PathVariable("id") Long countyId, County county, Model model) {
        county.setId(countyId);
        boolean updateResult = countyService.updateCounty(county);

        if (updateResult) {
            model.addAttribute("message", "County has been successfully updated");
            model.addAttribute("messageType", "success");
            return showAllCounties(model);
        } else {
            model.addAttribute("county", county);
            model.addAttribute("message", "Error in updating a county");
            model.addAttribute("messageType", "error");
            return "county/county-update";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCounty(@PathVariable("id") Long countyId, Model model) {
        boolean deleteResult = countyService.deleteCountyById(countyId);

        if (deleteResult) {
            model.addAttribute("message", "County has been successfully deleted");
            model.addAttribute("messageType", "success");

        } else {
            model.addAttribute("message", "Error in deleting a county");
            model.addAttribute("messageType", "error");
        }
        return showAllCounties(model);
    }

    @GetMapping("/restore/{id}")
    public String restoreCounty(@PathVariable("id") Long countyId, Model model) {
        boolean restoreResult = countyService.restoreCountyById(countyId);

        if (restoreResult) {
            model.addAttribute("message", "County has been successfully restored");
            model.addAttribute("messageType", "success");

        } else {
            model.addAttribute("message", "Error in restoring a county");
            model.addAttribute("messageType", "error");
        }
        return showAllCounties(model);
    }

}
