package com.sbt.demo.repositories;

import com.sbt.demo.repositories.entities.Nomenclature;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NomenclatureRepository extends CrudRepository<Nomenclature, Long> {

    @Modifying
    @Query("INSERT INTO nomenclature (id, name, description, acidity, density, price) " +
           "VALUES (:id, :name, :description, :acidity, :density, :price) " +
           "ON CONFLICT DO NOTHING")
    void create(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("description") String description,
            @Param("acidity") Float acidity,
            @Param("density") Float density,
            @Param("price") Float price
    );
}
