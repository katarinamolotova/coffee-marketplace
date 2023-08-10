package com.sbt.demo.repositories.mappers;

import com.sbt.demo.enums.PaymentStatus;
import com.sbt.demo.enums.PaymentType;
import com.sbt.demo.repositories.entities.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentRowMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
        Payment payment = new Payment();
        payment.setId(resultSet.getLong("id"));
        payment.setPaymentType(PaymentType.valueOf(resultSet.getString("type")));
        payment.setPaymentStatus(PaymentStatus.valueOf(resultSet.getString("status")));
        payment.setPaymentReceiptId(resultSet.getString("receipt_id"));
        return payment;
    }
}
