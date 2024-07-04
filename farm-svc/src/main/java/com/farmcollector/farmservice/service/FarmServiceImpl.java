package com.farmcollector.farmservice.service;

import com.farmcollector.farmservice.dto.Report;
import com.farmcollector.farmservice.entity.Crop;
import com.farmcollector.farmservice.entity.Farm;
import com.farmcollector.farmservice.entity.Field;
import com.farmcollector.farmservice.entity.Season;
import com.farmcollector.farmservice.repository.CropRepository;
import com.farmcollector.farmservice.repository.FarmRepository;
import com.farmcollector.farmservice.repository.FieldRepository;
import com.farmcollector.farmservice.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmServiceImpl implements FarmService{

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public Farm saveFarm(Farm farm) {

        // Retrieve or save the Field entity
        Field field = farm.getField();
        Optional<Field> existingField = fieldRepository.findByName(field.getName());
        if (existingField.isPresent()) {
            farm.setField(existingField.get());
        } else {
            fieldRepository.save(field);
        }

        // Retrieve or save the Crop entity
        Crop crop = farm.getCrop();
        Optional<Crop> existingCrop = cropRepository.findByName(crop.getName());
        if (existingCrop.isPresent()) {
            farm.setCrop(existingCrop.get());
        } else {
            cropRepository.save(crop);
        }

        // Retrieve or save the Season entity
        Season season = farm.getSeason();
        Optional<Season> existingSeason = seasonRepository.findByName(season.getName());
        if (existingSeason.isPresent()) {
            farm.setSeason(existingSeason.get());
        } else {
            seasonRepository.save(season);
        }

        return farmRepository.save(farm);


    }

    @Override
    public List<Report> getReportsByFarm(String name, String seasonName) {
        List<Farm> farms = farmRepository.findByNameAndSeasonName(name, seasonName);
        return farms.stream()
                .map(farm -> new Report(farm.getName(),farm.getField().getName(),farm.getSeason().getName(), farm.getCrop().getName(), farm.getExpectedProduct(), farm.getActualProduct()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Report> getReportsByCropType(String cropName, String seasonName) {
        List<Farm> farms = farmRepository.findByCropNameAndSeasonName(cropName, seasonName);
        return farms.stream()
                .map(farm -> new Report(farm.getName(), farm.getField().getName(),farm.getSeason().getName(),farm.getCrop().getName(), farm.getExpectedProduct(), farm.getActualProduct()))
                .collect(Collectors.toList());
    }

    @Override
    public Farm updateHarvested(Farm farm) {
        // Retrieve the existing Farm entity
        Farm existingfarm = farmRepository.findByNameAndFieldNameAndCropNameAndSeasonName(farm.getName(), farm.getField().getName(), farm.getCrop().getName(), farm.getSeason().getName())
                .orElseThrow(() -> new IllegalArgumentException("Farm not found for the specified parameters"));

        // Update the actualProduct
        existingfarm.setActualProduct(farm.getActualProduct());

        // Save the updated Farm entity
        return farmRepository.save(existingfarm);
    }
}
