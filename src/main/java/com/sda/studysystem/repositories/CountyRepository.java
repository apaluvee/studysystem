package com.sda.studysystem.repositories;

import com.sda.studysystem.models.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for County entity
 *
 * @author Alar
 */

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
}
