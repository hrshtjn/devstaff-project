package com.farmcollector.farmservice.repository;

import com.farmcollector.farmservice.entity.Crop;
import com.farmcollector.farmservice.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CropRepository extends JpaRepository<Crop,Long> {
    Optional<Crop> findByName(String name);
}
