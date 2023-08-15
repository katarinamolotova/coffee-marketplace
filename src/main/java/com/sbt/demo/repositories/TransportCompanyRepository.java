package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.TransportCompany;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportCompanyRepository extends CrudRepository<TransportCompany, Long> {

    @Modifying
    @Query("INSERT INTO transport_company (id, short_name, full_name, inn, kpp, okpo, ogrn, address) " +
           "VALUES (:id, :shortName, :fullName, :inn, :kpp, :okpo, :ogrn, :address) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long id,
            @Param("shortName") String shortName,
            @Param("fullName") String fullName,
            @Param("inn") String inn,
            @Param("kpp") String kpp,
            @Param("okpo") String okpo,
            @Param("ogrn") String ogrn,
            @Param("address") String address
    );
}
