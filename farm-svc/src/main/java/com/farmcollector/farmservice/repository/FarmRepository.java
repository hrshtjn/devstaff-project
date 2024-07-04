package com.farmcollector.farmservice.repository;

import com.farmcollector.farmservice.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FarmRepository extends JpaRepository<Farm,Long> {

    List<Farm> findByNameAndSeasonName(String name, String seasonName);
    List<Farm> findByCropNameAndSeasonName(String cropName, String seasonName);

    Optional<Farm> findByNameAndFieldNameAndCropNameAndSeasonName(String farmName, String fieldName, String cropName, String seasonName);
}
