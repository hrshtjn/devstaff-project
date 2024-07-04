package com.farmcollector.farmservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "FARM")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Field field;

    @ManyToOne
    private Crop crop;

    @ManyToOne
    private Season season;

    private double plantingArea;
    private double expectedProduct;
    private double actualProduct;

}
