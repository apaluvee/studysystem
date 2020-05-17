package com.sda.studysystem.repositories;

import com.sda.studysystem.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for City entity
 *
 * @author Alar
 */

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
