package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.Payment;
import com.sbt.demo.services.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper extends AbstractMapper<Payment, PaymentDTO> {

    @Autowired
    PaymentMapper() {
        super(Payment.class, PaymentDTO.class);
    }
}
