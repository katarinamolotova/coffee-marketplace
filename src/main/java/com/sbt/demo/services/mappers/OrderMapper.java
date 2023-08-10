package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.Order;
import com.sbt.demo.services.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper extends AbstractMapper<Order, OrderDTO> {

    @Autowired
    OrderMapper() {
        super(Order.class, OrderDTO.class);
    }

    @Override
    public Order toModel(OrderDTO dto) {
        Order order = super.toModel(dto);
        if (order != null) {
            order.setOrderPaymentId(dto.getOrderPayment() == null ? null : dto.getOrderPayment().getId());
            order.setOrderDeliveryId(dto.getOrderDelivery() == null ? null : dto.getOrderDelivery().getId());

            //       Варианты убрать тернарники
//            order.setOrderPaymentId(Optional.ofNullable(dto.getOrderPayment())
//                    .map(PaymentDTO::getId)
//                    .orElse(null));
//
//            Optional.ofNullable(dto.getOrderPayment())
//                    .map(PaymentDTO::getId)
//                    .ifPresent(order::setOrderPaymentId);
        }
        return order;
    }

}
