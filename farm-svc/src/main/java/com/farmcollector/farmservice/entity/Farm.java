package com.farmcollector.farmservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Farm name must be alphanumeric")
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
