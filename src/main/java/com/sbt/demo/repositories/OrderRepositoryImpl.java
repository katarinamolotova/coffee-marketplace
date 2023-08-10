package com.sbt.demo.repositories;

import com.sbt.demo.config.ApplicationConfig;
import com.sbt.demo.repositories.entities.Order;
import com.sbt.demo.repositories.mappers.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl {
    private final JdbcTemplate template;
    private final String tableName = "\"order\"";

    @Autowired
    OrderRepositoryImpl(ApplicationConfig config) {
        template = config.jdbcTemplate();
    }

    public Order findById(Long id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        return template.query(sql, new Object[] { id }, new OrderRowMapper())
                .stream().findFirst().orElse(null);
    }

    public boolean save(Order entity) {
        String sql = "INSERT INTO " + tableName + " VALUES (?, ?::order_type, ?::order_status, ?," +
                "?, ?, ?, ?, ?, ?, ?, ?)";
        if (findById(entity.getOrderId()) != null)
            return false;
        return template.update(sql, entity.getOrderId(), entity.getOrderType().toString(),
                entity.getOrderStatus().toString(), entity.getUserId(), entity.getCost(),
                entity.getDiscount(), entity.getTotalCost(), entity.getOrderPaymentId(),
                entity.getOrderDeliveryId(), entity.getCreateTs(), entity.getUpdateTs(),
                entity.isDeleted()) == 1;
    }
}
