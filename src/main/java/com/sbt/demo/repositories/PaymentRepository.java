package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.Payment;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Modifying
    @Query("INSERT INTO payment (id, status, type, receipt_id) " +
           "VALUES (:id, :status::payment_status, :type::payment_type, :receiptId) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long id,
            @Param("status") String status,
            @Param("type") String type,
            @Param("receiptId") String receiptId
    );
}
