package com.sbt.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sbt.demo.enums.GrindDegreeType;
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
    private Long count;
    private GrindDegreeType grindDegreeType;
    private Integer cost;
    private Long serialNumber;
}
