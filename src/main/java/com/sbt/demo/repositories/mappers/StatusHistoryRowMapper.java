package com.sbt.demo.repositories.mappers;

import com.sbt.demo.enums.OrderStatus;
import com.sbt.demo.repositories.entities.StatusHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusHistoryRowMapper implements RowMapper<StatusHistory> {

    @Override
    public StatusHistory mapRow(ResultSet resultSet, int i) throws SQLException {
        StatusHistory statusHistory = new StatusHistory();
        statusHistory.setId(resultSet.getLong("id"));
        statusHistory.setOrderId(resultSet.getLong("order_id"));
        statusHistory.setOrderStatus(OrderStatus.valueOf(resultSet.getString("status")));
        statusHistory.setOperationTime(resultSet.getTimestamp("operation_time").toLocalDateTime());
        return statusHistory;
    }
}
