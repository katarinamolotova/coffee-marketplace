package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.GrindDegreeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("order_item")
public class OrderItem {

    @Id
    @Column("id")
    private Long orderItemId;

    @Column("order_id")
    private Long orderId;

    @Column("nomenclature_id")
    private Long nomenclatureId;

    @Column("count")
    private Long count;

    @Column("grind_degree_type")
    private GrindDegreeType grindDegreeType;

    @Column("cost")
    private Integer cost;

    @Column("serial_number")
    private Long serialNumber;
}
