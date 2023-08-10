package com.sbt.demo.services;

import com.sbt.demo.repositories.PaymentRepositoryImpl;
import com.sbt.demo.services.dto.PaymentDTO;
import com.sbt.demo.services.mappers.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepositoryImpl paymentRepository;

    @Autowired
    public PaymentService(
            PaymentMapper paymentMapper,
            PaymentRepositoryImpl paymentRepository
    ) {
        this.paymentMapper = paymentMapper;
        this.paymentRepository = paymentRepository;
    }

    public void saveListOfPayments(List<PaymentDTO> payments) {
        payments.forEach(
                payment -> paymentRepository.save(paymentMapper.toModel(payment))
        );
    }
}
