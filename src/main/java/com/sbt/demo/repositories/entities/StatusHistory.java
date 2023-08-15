package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("status_history")
public class StatusHistory {

    @Id
    @Column("id")
    private Long id;

    @Column("order_id")
    private Long orderId;

    @Column("status")
    private OrderStatus orderStatus;

    @Column("operation_time")
    private LocalDateTime operationTime;
}
