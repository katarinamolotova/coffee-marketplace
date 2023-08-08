package com.sbt.demo.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sbt.demo.enums.GrindDegreeType;
import com.sbt.demo.models.Nomenclature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemDTO {
    private Long orderItemId;
    private Nomenclature nomenclature;
    private Long count;
    private GrindDegreeType grindDegreeType;
    private Integer cost;
    private Long serialNumber;
}
