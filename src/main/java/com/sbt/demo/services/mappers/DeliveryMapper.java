package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.Delivery;
import com.sbt.demo.services.dto.DeliveryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DeliveryMapper extends AbstractMapper<Delivery, DeliveryDTO> {
    private final ModelMapper mapper;

    @Autowired
    DeliveryMapper(ModelMapper mapper) {
        super(Delivery.class, DeliveryDTO.class);
        this.mapper = mapper;
    }

    @Override
    public Delivery toModel(DeliveryDTO dto) {
        Delivery delivery = Objects.isNull(dto)
                ? null
                : mapper.map(dto, Delivery.class);
        if (delivery != null)
            delivery.setTransportCompanyId(dto.getTransportCompany().getId());
        return delivery;
    }
}
