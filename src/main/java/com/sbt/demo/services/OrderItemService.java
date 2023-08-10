package com.sbt.demo.services;

import com.sbt.demo.repositories.OrderItemRepositoryImpl;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.services.dto.OrderItemDTO;
import com.sbt.demo.services.mappers.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    private final OrderItemMapper orderItemMapper;
    private final OrderItemRepositoryImpl orderItemRepository;

    @Autowired
    public OrderItemService(
            OrderItemMapper orderItemMapper,
            OrderItemRepositoryImpl orderItemRepository
    ) {
        this.orderItemMapper = orderItemMapper;
        this.orderItemRepository = orderItemRepository;
    }

    public void save(OrderItemDTO orderItem, OrderDTO order) {
        orderItemRepository.save(orderItemMapper.toModel(orderItem, order));
    }
}
