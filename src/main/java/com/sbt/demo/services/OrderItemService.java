package com.sbt.demo.services;

import com.sbt.demo.repositories.OrderItemRepository;
import com.sbt.demo.repositories.entities.OrderItem;
import com.sbt.demo.services.dto.OrderItemDTO;
import com.sbt.demo.services.mappers.OrderItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemMapper orderItemMapper;
    private final OrderItemRepository orderItemRepository;

    public void saveMapOfOrderIdAndOrderItems(final Map<Long, List<OrderItemDTO>> orderIdAndOrderItems) {
        orderIdAndOrderItems.forEach(
            (id, orderItems) -> orderItems.forEach(
                orderItem -> {
                    final OrderItem entity = orderItemMapper.toModel(orderItem, id);
                    orderItemRepository.create(
                            entity.getOrderItemId(),
                            entity.getOrderId(),
                            entity.getNomenclatureId(),
                            entity.getCount(),
                            entity.getGrindDegreeType().toString(),
                            entity.getCost(),
                            entity.getSerialNumber()
                    );
                }
            )
        );
    }
}
