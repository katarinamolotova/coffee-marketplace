package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.Order;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Modifying
    @Query("INSERT INTO \"order\" (id, type, status, user_id, cost, discount, total_cost, payment_id, delivery_id, " +
           "                       create_ts, update_ts, deleted) " +
           "VALUES (:id, :type::order_type, :status::order_status, :userId, :cost, :discount, :totalCost, :paymentId, " +
           "        :deliveryId, :createTs, :updateTs, :deleted) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long orderId,
            @Param("type") String orderType,
            @Param("status") String orderStatus,
            @Param("userId") String userId,
            @Param("cost") Float cost,
            @Param("discount") Float discount,
            @Param("totalCost") Float totalCost,
            @Param("paymentId") Long orderPaymentId,
            @Param("deliveryId") Long orderDeliveryId,
            @Param("createTs") LocalDateTime createTs,
            @Param("updateTs") LocalDateTime updateTs,
            @Param("deleted") Boolean deleted
    );
}
