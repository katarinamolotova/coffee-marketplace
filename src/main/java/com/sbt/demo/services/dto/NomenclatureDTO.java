package com.sbt.demo.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NomenclatureDTO {

    @JsonProperty("nomenclatureId")
    private Long id;
    private String name;
    private String description;
    private Float acidity;
    private Float density;
    private Float price;
}
