package com.sbt.demo.repositories.mappers;


import com.sbt.demo.repositories.entities.TransportCompany;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportCompanyRowMapper implements RowMapper<TransportCompany> {

    @Override
    public TransportCompany mapRow(ResultSet resultSet, int i) throws SQLException {
        TransportCompany transportCompany = new TransportCompany();
        transportCompany.setId(resultSet.getLong("id"));
        transportCompany.setShortName(resultSet.getString("short_name"));
        transportCompany.setFullName(resultSet.getString("full_name"));
        transportCompany.setInn(resultSet.getString("inn"));
        transportCompany.setKpp(resultSet.getString("kpp"));
        transportCompany.setOkpo(resultSet.getString("okpo"));
        transportCompany.setOgrn(resultSet.getString("ogrn"));
        transportCompany.setAddress(resultSet.getString("address"));
        return transportCompany;
    }
}
