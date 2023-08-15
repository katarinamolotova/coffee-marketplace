package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.StatusHistory;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface StatusHistoryRepository extends CrudRepository<StatusHistory, Long> {

    @Modifying
    @Query("INSERT INTO status_history (id, order_id, status, operation_time) " +
           "VALUES (:id, :orderId, :status::order_status, :operationTime) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long id,
            @Param("orderId") Long orderId,
            @Param("status") String status,
            @Param("operationTime") LocalDateTime operationTime
    );
}

