package com.sbt.demo.repositories.mappers;

import com.sbt.demo.enums.OrderStatus;
import com.sbt.demo.enums.OrderType;
import com.sbt.demo.repositories.entities.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getLong("id"));
        order.setOrderType(OrderType.valueOf(resultSet.getString("type")));
        order.setOrderStatus(OrderStatus.valueOf(resultSet.getString("status")));
        order.setUserId(resultSet.getString("user_id"));
        order.setCost(resultSet.getFloat("cost"));
        order.setDiscount(resultSet.getFloat("discount"));
        order.setTotalCost(resultSet.getFloat("total_cost"));
        order.setOrderPaymentId(resultSet.getLong("payment_id"));
        order.setOrderDeliveryId(resultSet.getLong("delivery_id"));
        order.setCreateTs(resultSet.getTimestamp("create_ts").toLocalDateTime());
        order.setUpdateTs(resultSet.getTimestamp("update_ts").toLocalDateTime());
        order.setDeleted(resultSet.getBoolean("deleted"));
        return order;
    }
}
