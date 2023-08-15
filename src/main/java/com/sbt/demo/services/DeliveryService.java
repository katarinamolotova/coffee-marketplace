package com.sbt.demo.services;

import com.sbt.demo.repositories.DeliveryRepository;
import com.sbt.demo.repositories.entities.Delivery;
import com.sbt.demo.services.dto.DeliveryDTO;
import com.sbt.demo.services.mappers.DeliveryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    public void saveListOfDeliveries(final List<DeliveryDTO> deliveries) {
        deliveries.forEach(
                delivery -> {
                    final Delivery entity = deliveryMapper.toModel(delivery);
                    deliveryRepository.create(
                            entity.getId(),
                            entity.getTransportCompanyId(),
                            entity.getDeliveryStatus().toString(),
                            entity.getAddress()
                    );
                }
        );
    }
}
