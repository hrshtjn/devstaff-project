package com.farmcollector.farmservice.repository;

import com.farmcollector.farmservice.entity.Crop;
import com.farmcollector.farmservice.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season,Long> {
    Optional<Season> findByName(String name);
}
