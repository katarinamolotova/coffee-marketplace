package com.sbt.demo.repositories;

import com.sbt.demo.config.ApplicationConfig;
import com.sbt.demo.repositories.entities.OrderItem;
import com.sbt.demo.repositories.mappers.OrderItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepositoryImpl {
    private final JdbcTemplate template;

    @Autowired
    OrderItemRepositoryImpl(ApplicationConfig config) {
        template = config.jdbcTemplate();
    }

    public OrderItem findById(Long id) {
        String sql = "SELECT * FROM order_item WHERE id = ?";
        return template.query(sql, new Object[] { id }, new OrderItemRowMapper())
                .stream().findFirst().orElse(null);
    }

    public boolean save(OrderItem entity) {
        String sql = "INSERT INTO order_item VALUES (?, ?, ?, ?, " +
                "?::grind_degree_type, ?, ?)";
        if (findById(entity.getOrderItemId()) != null)
            return false;
        return template.update(sql, entity.getOrderItemId(), entity.getOrderId(),
                entity.getNomenclatureId(), entity.getCount(),
                entity.getGrindDegreeType().toString(),
                entity.getCost(), entity.getSerialNumber()) == 1;
    }
}
