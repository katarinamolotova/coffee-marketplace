package com.sbt.demo.services;

import com.sbt.demo.repositories.OrderRepository;
import com.sbt.demo.repositories.entities.Order;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.services.mappers.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public void saveListOfOrders(List<OrderDTO> orders) {
        orders.forEach(
                order -> {
                    final Order entity = orderMapper.toModel(order);
                    orderRepository.create(
                            entity.getOrderId(),
                            entity.getOrderType().toString(),
                            entity.getOrderStatus().toString(),
                            entity.getUserId(),
                            entity.getCost(),
                            entity.getDiscount(),
                            entity.getTotalCost(),
                            entity.getOrderPaymentId(),
                            entity.getOrderDeliveryId(),
                            entity.getCreateTs(),
                            entity.getUpdateTs(),
                            entity.isDeleted()
                    );
                }
        );
    }
}
