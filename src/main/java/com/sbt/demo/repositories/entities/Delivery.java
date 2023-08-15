package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.DeliveryStatus;
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
@Table("delivery")
public class Delivery {

    @Id
    @Column("id")
    private Long id;

    @Column("transport_company_id")
    private Long transportCompanyId;

    @Column("status")
    private DeliveryStatus deliveryStatus;

    @Column("address")
    private String address;
}
