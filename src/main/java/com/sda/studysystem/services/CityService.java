package com.sda.studysystem.services;

import com.sda.studysystem.models.City;

import java.util.List;

/**
 * Service to handle City related operations
 * @author Alar
 */

public interface CityService {

    /**
     * To create a new City
     *
     * @param city City
     */
    boolean createCity(City city);

    /**
     * To update an existing City
     *
     * @param city city
     * @return update result
     */
    boolean updateCity(City city);

    /**
     * To get a city by its id
     *
     * @param cityId id of a city
     * @return City
     */
    City getById(Long cityId);

    /**
     * To get all the Citys
     * @return list of all citys
     */
    List<City> getAllCities();

    /**
     * To delete a city (change active state)
     *
     * @param cityId cityId
     * @return is it deleted
     */
    boolean deleteCityById(Long cityId);

    /**
     * To restore a city (change active state)
     *
     * @param cityId
     * @return
     */
    boolean restoreCityById(Long cityId);
}

