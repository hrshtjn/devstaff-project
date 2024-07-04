package com.farmcollector.farmservice.repository;

import com.farmcollector.farmservice.entity.Farm;
import com.farmcollector.farmservice.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FieldRepository extends JpaRepository<Field,Long> {
    Optional<Field> findByName(String name);
}
