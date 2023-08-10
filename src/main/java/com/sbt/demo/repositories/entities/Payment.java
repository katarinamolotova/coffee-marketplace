package com.sbt.demo.repositories.entities;

import com.sbt.demo.enums.PaymentStatus;
import com.sbt.demo.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private String paymentReceiptId;
}
