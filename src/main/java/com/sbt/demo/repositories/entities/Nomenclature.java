package com.sbt.demo.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nomenclature {
    private Long id;
    private String name;
    private String description;
    private Float acidity;
    private Float density;
    private Float price;
}
