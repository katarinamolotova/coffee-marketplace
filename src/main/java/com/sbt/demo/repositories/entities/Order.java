package com.sbt.demo.repositories.entities;


import com.sbt.demo.enums.OrderStatus;
import com.sbt.demo.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private OrderType orderType;
    private OrderStatus orderStatus;
    private String userId;
    private Float cost;
    private Float discount;
    private Float totalCost;
    private Long orderPaymentId;
    private Long orderDeliveryId;
    private LocalDateTime createTs;
    private LocalDateTime updateTs;
    private boolean deleted;
}
