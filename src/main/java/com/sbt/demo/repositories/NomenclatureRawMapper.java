package com.sbt.demo.repositories;

import com.sbt.demo.models.Nomenclature;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NomenclatureRawMapper implements RowMapper<Nomenclature> {

    @Override
    public Nomenclature mapRow(ResultSet resultSet, int i) throws SQLException {
        Nomenclature nomenclature = new Nomenclature();
        nomenclature.setId(resultSet.getLong("id"));
        nomenclature.setName(resultSet.getString("name"));
        nomenclature.setDescription(resultSet.getString("description"));
        nomenclature.setDensity(resultSet.getFloat("density"));
        nomenclature.setAcidity(resultSet.getFloat("acidity"));
        nomenclature.setPrice(resultSet.getFloat("price"));
        return null;
    }
}