package com.sbt.demo.services.dto;


import com.fasterxml.jackson.annotation.*;
import com.sbt.demo.enums.OrderStatus;
import com.sbt.demo.enums.OrderType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private Long orderId;
    private OrderType orderType;
    private OrderStatus orderStatus;
    private String userId;
    private Float cost;
    private Float discount;
    private Float totalCost;
    private PaymentDTO orderPayment;
    private DeliveryDTO orderDelivery;
    private LocalDateTime createTs;
    private LocalDateTime updateTs;
    private List<OrderItemDTO> orderItems;
    private List<StatusHistoryDTO> statusHistory;

    @JsonIgnore
    private boolean isDeleted;

    @JsonSetter("deleteTs")
    private void setIsDeletedFromDeletedTime(String deleteTs) {
        isDeleted = (deleteTs != null);
    }

    @JsonGetter("isDeleted")
    private boolean isDeleted() {
        return isDeleted;
    }
}
