package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.Order;
import com.sbt.demo.services.dto.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderMapper extends AbstractMapper<Order, OrderDTO> {
    private final ModelMapper mapper;

    @Autowired
    OrderMapper(ModelMapper mapper) {
        super(Order.class, OrderDTO.class);
        this.mapper = mapper;
    }

    @Override
    public Order toModel(OrderDTO dto) {
        Order order = Objects.isNull(dto)
                ? null
                : mapper.map(dto, Order.class);
        if (order != null) {
            order.setOrderPaymentId(dto.getOrderPayment() == null ? null : dto.getOrderPayment().getId());
            order.setOrderDeliveryId(dto.getOrderDelivery() == null ? null : dto.getOrderDelivery().getId());
        }
        return order;
    }

}
