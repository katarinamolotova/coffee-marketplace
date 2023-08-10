package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusHistory {
    private Long id;
    private Long orderId;
    private OrderStatus orderStatus;
    private LocalDateTime operationTime;
}
