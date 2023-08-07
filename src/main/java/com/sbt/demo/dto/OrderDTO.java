package com.sbt.demo.dto;


import com.fasterxml.jackson.annotation.*;
import com.sbt.demo.enums.OrderStatus;
import com.sbt.demo.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private Long orderId;
    private OrderType orderType;
    private OrderStatus orderStatus;
    private LocalDateTime createTs;
    private LocalDateTime updateTs;

    @JsonIgnore
    private boolean isDeleted;

    @JsonSetter("isDeleted")
    private void setIsDeleted(String deleteTs) {
        isDeleted = (deleteTs != null);
    }

    @JsonGetter("isDeleted")
    private boolean getIsDeleted() {
        return isDeleted;
    }
}
