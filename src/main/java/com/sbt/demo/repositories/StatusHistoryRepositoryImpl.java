package com.sbt.demo.repositories;

import com.sbt.demo.config.ApplicationConfig;
import com.sbt.demo.repositories.entities.StatusHistory;
import com.sbt.demo.repositories.mappers.StatusHistoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatusHistoryRepositoryImpl {
    private final JdbcTemplate template;

    @Autowired
    StatusHistoryRepositoryImpl(ApplicationConfig config) {
        template = config.jdbcTemplate();
    }

    public StatusHistory findById(Long id) {
        String sql = "SELECT * FROM status_history WHERE id = ?";
        return template.query(sql, new Object[] { id }, new StatusHistoryRowMapper())
                .stream().findFirst().orElse(null);
    }

    public boolean save(StatusHistory entity) {
        String sql = "INSERT INTO status_history VALUES (?, ?, ?::order_status, ?)";
        if (findById(entity.getId()) != null)
            return false;
        return template.update(sql, entity.getId(), entity.getOrderId(),
                entity.getOrderStatus().toString(), entity.getOperationTime()) == 1;
    }
}
