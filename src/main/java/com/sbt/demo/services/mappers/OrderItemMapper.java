package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.OrderItem;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.services.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderItemMapper extends AbstractMapper<OrderItem, OrderItemDTO> {

    @Autowired
    OrderItemMapper() {
        super(OrderItem.class, OrderItemDTO.class);
    }

    public OrderItem toModel(OrderItemDTO dto, OrderDTO parent) {
        OrderItem orderItem = super.toModel(dto);
        if (orderItem != null) {
            orderItem.setOrderId(parent.getOrderId());
            orderItem.setNomenclatureId(dto.getNomenclature().getId());
        }
        return orderItem;
    }
}
