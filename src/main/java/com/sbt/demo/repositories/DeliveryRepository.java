package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.Delivery;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    @Modifying
    @Query("INSERT INTO delivery (id, transport_company_id, status, address) " +
           "VALUES (:id, :transportCompanyId, :deliveryStatus::delivery_status, :address) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long id,
            @Param("transportCompanyId") Long transportCompanyId,
            @Param("deliveryStatus") String deliveryStatus,
            @Param("address") String address
    );
}
