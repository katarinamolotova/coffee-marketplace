package com.sbt.demo.repositories.mappers;

import com.sbt.demo.enums.GrindDegreeType;
import com.sbt.demo.repositories.entities.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(resultSet.getLong("id"));
        orderItem.setOrderId(resultSet.getLong("order_id"));
        orderItem.setNomenclatureId(resultSet.getLong("nomenclature_id"));
        orderItem.setCount(resultSet.getLong("count"));
        orderItem.setGrindDegreeType(GrindDegreeType.valueOf(resultSet.getString("grind_degree_type")));
        orderItem.setCost(resultSet.getInt("cost"));
        orderItem.setSerialNumber(resultSet.getLong("serial_number"));
        return orderItem;
    }
}
