package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.Delivery;
import com.sbt.demo.services.dto.DeliveryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeliveryMapper extends AbstractMapper<Delivery, DeliveryDTO> {

    @Autowired
    DeliveryMapper() {
        super(Delivery.class, DeliveryDTO.class);
    }

    @Override
    public Delivery toModel(DeliveryDTO dto) {
        Delivery delivery = super.toModel(dto);
        if (delivery != null) {
            delivery.setTransportCompanyId(dto.getTransportCompany().getId());
        }
        return delivery;
    }
}
