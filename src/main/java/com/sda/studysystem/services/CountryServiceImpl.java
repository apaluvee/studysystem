package com.sda.studysystem.services;

import com.sda.studysystem.models.Country;
import com.sda.studysystem.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CountryService
 *
 * @author Alar
 */

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountyService countyService;

    @Autowired
    private CityService cityService;

    @Autowired
    private SchoolService schoolService;

    @Override
    public boolean createCountry(Country country) {
        if (country == null) {
            return false;
        }
        country.setActive(true);
        countryRepository.save(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        if (country == null || !countryRepository.existsById(country.getId())) {
            return false;
        }

        countryRepository.saveAndFlush(country);
        return true;
    }

    @Override
    public Country getById(Long countryId) {
        return countryRepository.getOne(countryId);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public boolean deleteCountryById(Long countryId) {
        Country country = getById(countryId);
        if (countryId == null) {
            return false;
        }

        country.setActive(false);
        updateCountry(country);

        countyService.getAllCounties().stream()
                .filter(county -> county.getCountry().getId().equals(countryId))
                .forEach(county -> countyService.deleteCountyById(county.getId()));

        cityService.getAllCities().stream()
                .filter(city -> city.getCountry().getId().equals(countryId))
                .forEach(city -> cityService.deleteCityById(city.getId()));

        schoolService.getAllSchools().stream()
                .filter(school -> school.getCountry().getId().equals(countryId))
                .forEach(school -> schoolService.deleteSchoolById(school.getId()));
        return true;
    }

    @Override
    public boolean restoreCountryById(Long countryId) {
        Country country = getById(countryId);
        if (countryId == null) {
            return false;
        }

        country.setActive(true);
        updateCountry(country);

        countyService.getAllCounties().stream()
                .filter(county -> county.getCountry().getId().equals(countryId))
                .forEach(county -> countyService.restoreCountyById(county.getId()));

        cityService.getAllCities().stream()
                .filter(city -> city.getCountry().getId().equals(countryId))
                .forEach(city -> cityService.restoreCityById(city.getId()));

        schoolService.getAllSchools().stream()
                .filter(school -> school.getCountry().getId().equals(countryId))
                .forEach(school -> schoolService.restoreSchoolById(school.getId()));

        return true;
    }
}

