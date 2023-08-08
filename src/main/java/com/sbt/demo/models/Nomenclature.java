package com.sbt.demo.models;

import lombok.Data;

@Data
public class Nomenclature {
    private Long id;
    private String name;
    private String description;
    private Float acidity;
    private Float density;
    private Float price;
}
