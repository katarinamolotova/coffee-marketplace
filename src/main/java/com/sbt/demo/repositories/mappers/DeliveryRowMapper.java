package com.sbt.demo.repositories.mappers;

import com.sbt.demo.enums.DeliveryStatus;
import com.sbt.demo.repositories.entities.Delivery;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryRowMapper implements RowMapper<Delivery> {

    @Override
    public Delivery mapRow(ResultSet resultSet, int i) throws SQLException {
        Delivery delivery = new Delivery();
        delivery.setId(resultSet.getLong("id"));
        delivery.setAddress(resultSet.getString("address"));
        delivery.setDeliveryStatus(DeliveryStatus.valueOf(resultSet.getString("status")));
        delivery.setTransportCompanyId(resultSet.getLong("transport_company_id"));
        return delivery;
    }
}

