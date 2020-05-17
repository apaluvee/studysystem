package com.sda.studysystem.repositories;

import com.sda.studysystem.models.SpecializedField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for SpecializedField entity
 *
 * @author Alar
 */

@Repository
public interface SpecializedFieldRepository extends JpaRepository<SpecializedField, Long> {
}
