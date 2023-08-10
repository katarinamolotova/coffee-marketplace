package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    private Long id;
    private Long transportCompanyId;
    private DeliveryStatus deliveryStatus;
    private String address;
}
