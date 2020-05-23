package com.sda.studysystem.services;

import com.sda.studysystem.models.County;
import com.sda.studysystem.repositories.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CountyService
 *
 * @author Alar
 */

@Service
public class CountyServiceImpl implements CountyService {
    @Autowired
    private CountyRepository countyRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private SchoolService schoolService;

    @Override
    public boolean createCounty(County county) {
        if (county == null) {
            return false;
        }

        county.setActive(true);
        countyRepository.save(county);
        return true;
    }

    @Override
    public boolean updateCounty(County county) {
        if (county == null || !countyRepository.existsById(county.getId())) {
            return false;
        }

        countyRepository.saveAndFlush(county);
        return true;
    }

    @Override
    public County getById(Long countyId) {
        return countyRepository.getOne(countyId);
    }

    @Override
    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }

    @Override
    public boolean deleteCountyById(Long countyId) {
        County county = getById(countyId);
        if (countyId == null) {
            return false;
        }

        county.setActive(false);
        updateCounty(county);

        cityService.getAllCities().stream()
                .filter(city -> city.getCounty().getId().equals(countyId))
                .forEach(city -> cityService.deleteCityById(city.getId()));

        schoolService.getAllSchools().stream()
                .filter(school -> school.getCounty().getId().equals(countyId))
                .forEach(school -> schoolService.deleteSchoolById(school.getId()));

        return true;
    }

    @Override
    public boolean restoreCountyById(Long countyId) {
        County county = getById(countyId);

        if (countyId == null || !countryService.getById(county.getCountry().getId()).isActive()) {
            return false;
        }

        county.setActive(true);
        updateCounty(county);

        cityService.getAllCities().stream()
                .filter(city -> city.getCounty().getId().equals(countyId))
                .forEach(city -> cityService.restoreCityById(city.getId()));

        schoolService.getAllSchools().stream()
                .filter(school -> school.getCounty().getId().equals(countyId))
                .forEach(school -> schoolService.restoreSchoolById(school.getId()));

        return true;
    }
}
