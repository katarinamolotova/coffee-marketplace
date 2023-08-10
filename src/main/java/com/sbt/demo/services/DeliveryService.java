package com.sbt.demo.services;

import com.sbt.demo.repositories.DeliveryRepositoryImpl;
import com.sbt.demo.services.dto.DeliveryDTO;
import com.sbt.demo.services.mappers.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    private final DeliveryRepositoryImpl deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Autowired
    public DeliveryService(
            DeliveryRepositoryImpl deliveryRepository,
            DeliveryMapper deliveryMapper
    ) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    public void save(DeliveryDTO delivery) {
        deliveryRepository.save(deliveryMapper.toModel(delivery));
    }
}
