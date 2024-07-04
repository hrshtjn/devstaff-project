package com.farmcollector.farmservice.service;

import com.farmcollector.farmservice.dto.Report;
import com.farmcollector.farmservice.entity.Farm;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FarmService {

    Farm saveFarm(Farm farm);

    List<Report> getReportsByFarm(String name, String seasonName);
    List<Report> getReportsByCropType(String cropName, String seasonName);

    Farm updateHarvested(Farm farm);
}
