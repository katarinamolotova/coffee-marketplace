package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.GrindDegreeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long nomenclatureId;
    private Long count;
    private GrindDegreeType grindDegreeType;
    private Integer cost;
    private Long serialNumber;
}
