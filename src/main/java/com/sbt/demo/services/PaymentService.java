package com.sbt.demo.services;

import com.sbt.demo.repositories.PaymentRepository;
import com.sbt.demo.repositories.entities.Payment;
import com.sbt.demo.services.dto.PaymentDTO;
import com.sbt.demo.services.mappers.PaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    public void saveListOfPayments(final List<PaymentDTO> payments) {
        payments.forEach(
                payment -> {
                    final Payment entity = paymentMapper.toModel(payment);
                    paymentRepository.create(
                            entity.getId(),
                            entity.getPaymentStatus().toString(),
                            entity.getPaymentType().toString(),
                            entity.getPaymentReceiptId()
                    );
                }
        );
    }
}
