package com.farmcollector.farmservice.controller;

import com.farmcollector.farmservice.dto.Report;
import com.farmcollector.farmservice.entity.Farm;
import com.farmcollector.farmservice.service.FarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Api(tags = "Farm Endpoints", description = "Endpoints for farm project")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @PostMapping("/planted")
    @ApiOperation("Submit planted data for a farm")
    public Farm planted(@RequestBody Farm farm) {
        return farmService.saveFarm(farm);
    }


    @PostMapping("/harvested")
    public Farm harvested(@RequestBody Farm farm) {
        return farmService.updateHarvested(farm);
    }

    @GetMapping("/reports/farm")
    public List<Report> getReportsByFarm(@RequestParam String name, @RequestParam String seasonName) {
        return farmService.getReportsByFarm(name, seasonName);
    }

    @GetMapping("/reports/crop")
    public List<Report> getReportsByCropType(@RequestParam String cropName, @RequestParam String seasonName) {
        return farmService.getReportsByCropType(cropName, seasonName);
    }
}
