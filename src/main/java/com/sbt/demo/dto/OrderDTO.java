package com.sbt.demo.dto;


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
    private LocalDateTime createTs;
    private LocalDateTime updateTs;
    private List<OrderItemDTO> orderItems;

    @JsonIgnore
    private boolean isDeleted;

    @JsonSetter("deleteTs")
    private void setIsDeleted(String deleteTs) {
        isDeleted = (deleteTs != null);
    }

    @JsonGetter("isDeleted")
    private boolean getIsDeleted() {
        return isDeleted;
    }
}