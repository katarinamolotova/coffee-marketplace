package com.sbt.demo.services;

import com.sbt.demo.repositories.OrderItemRepositoryImpl;
import com.sbt.demo.services.dto.OrderItemDTO;
import com.sbt.demo.services.mappers.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

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

    public void saveMapOfOrderIdAndOrderItems(Map<Long, List<OrderItemDTO>> orderIdAndOrderItems) {
        orderIdAndOrderItems.forEach(
                (id, orderItems) -> orderItems.forEach(
                        orderItem ->
                            orderItemRepository.save(orderItemMapper.toModel(orderItem, id))
                )
        );
    }
}
