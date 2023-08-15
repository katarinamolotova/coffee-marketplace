package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.PaymentStatus;
import com.sbt.demo.enums.PaymentType;
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
@Table("payment")
public class Payment {

    @Id
    @Column("id")
    private Long id;

    @Column("status")
    private PaymentStatus paymentStatus;

    @Column("type")
    private PaymentType paymentType;

    @Column("receipt_id")
    private String paymentReceiptId;
}
