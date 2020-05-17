package com.sda.studysystem.services;

import com.sda.studysystem.models.Country;
import com.sda.studysystem.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public boolean createCountry(Country country) {
        if (country == null) {
            return false;
        }
        country.setId(country.getId());
        countryRepository.save(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        if (country == null) {
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
        return false;
    }

    private String getNewCountryId() {
        double countryId = Math.random();
        return "" + countryId;
    }

    @Override
    public boolean restoreCountryById(Long countryId) {
        Country country = getById(countryId);
        if (countryId == null) {
            return false;
        }
        country.setActive(true);
        return updateCountry(country);
    }

}
