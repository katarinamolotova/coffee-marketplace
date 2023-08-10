package com.sbt.demo.services;

import com.sbt.demo.repositories.OrderRepositoryImpl;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.services.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepositoryImpl orderRepository;

    @Autowired
    public OrderService(
            OrderMapper orderMapper,
            OrderRepositoryImpl orderRepository
    ) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public void save(OrderDTO order) {
        orderRepository.save(orderMapper.toModel(order));
    }
}