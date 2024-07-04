package com.farmcollector.farmservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Report {

    private String farmName;
    private String fieldName;
    private String season;
    private String cropType;
    private double expectedProduct;
    private double actualProduct;



}
