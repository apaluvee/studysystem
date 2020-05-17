package com.sda.studysystem.services;

import com.sda.studysystem.models.City;
import com.sda.studysystem.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CityService
 *
 * @author Alar
 */

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public boolean createCity(City city) {
        if (city == null) {
            return false;
        }
        city.setId(city.getId());
        cityRepository.save(city);
        return true;
    }

    @Override
    public boolean updateCity(City city) {
        if (city == null) {
            return false;
        }
        cityRepository.saveAndFlush(city);
        return true;
    }

    @Override
    public City getById(Long cityId) {
        return cityRepository.getOne(cityId);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public boolean deleteCityById(Long cityId) {
        City city = getById(cityId);
        if (cityId == null) {
            return false;
        }
        city.setActive(false);
        updateCity(city);
        return false;
    }

    private String getNewCityId() {
        double cityId = Math.random();
        return "" + cityId;
    }

    @Override
    public boolean restoreCityById(Long cityId) {
        City city = getById(cityId);
        if (cityId == null) {
            return false;
        }
        city.setActive(true);
        return updateCity(city);
    }

}
