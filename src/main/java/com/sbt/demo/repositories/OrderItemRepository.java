package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.OrderItem;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    @Modifying
    @Query("INSERT INTO order_item (id, order_id, nomenclature_id, count, grind_degree_type, cost, serial_number) " +
           "VALUES (:id, :orderId, :nomenclatureId, :count, :grindDegreeType::grind_degree_type, :cost, :serialNumber) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long id,
            @Param("orderId") Long orderId,
            @Param("nomenclatureId") Long nomenclatureId,
            @Param("count") Long count,
            @Param("grindDegreeType") String grindDegreeType,
            @Param("cost") Integer cost,
            @Param("serialNumber") Long serialNumber
    );
}
