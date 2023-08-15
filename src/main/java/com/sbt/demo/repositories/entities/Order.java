package com.sbt.demo.repositories.entities;


import com.sbt.demo.enums.OrderStatus;
import com.sbt.demo.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("\"order\"")
public class Order {

    @Id
    @Column("id")
    private Long orderId;

    @Column("type")
    private OrderType orderType;

    @Column("status")
    private OrderStatus orderStatus;

    @Column("user_id")
    private String userId;

    @Column("cost")
    private Float cost;

    @Column("discount")
    private Float discount;

    @Column("total_cost")
    private Float totalCost;

    @Column("payment_id")
    private Long orderPaymentId;

    @Column("delivery_id")
    private Long orderDeliveryId;

    @Column("create_ts")
    private LocalDateTime createTs;

    @Column("update_ts")
    private LocalDateTime updateTs;

    @Column("deleted")
    private boolean deleted;
}
