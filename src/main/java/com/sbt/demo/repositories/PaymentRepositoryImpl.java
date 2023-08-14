package com.sbt.demo.repositories;

import com.sbt.demo.config.ApplicationConfig;
import com.sbt.demo.repositories.entities.Payment;
import com.sbt.demo.repositories.mappers.PaymentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepositoryImpl implements CrudRepository<Payment> {
    private final JdbcTemplate template;

    @Autowired
    PaymentRepositoryImpl(ApplicationConfig config) {
        this.template = config.jdbcTemplate();
    }

    @Override
    public Payment findById(Long id) {
        String sql = "SELECT * FROM payment WHERE id = ?";
        return template.query(sql, new Object[] { id }, new PaymentRowMapper())
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        String sql = "SELECT * FROM payment";
        return template.query(sql, new PaymentRowMapper());
    }

    @Override
    public boolean save(Payment entity) {
        String sql = "INSERT INTO payment VALUES (?, ?::payment_status, ?::payment_type, ?)";
        if (findById(entity.getId()) != null)
            return false;
        return template.update(sql, entity.getId(), entity.getPaymentStatus().toString(),
                entity.getPaymentType().toString(), entity.getPaymentReceiptId()) == 1;
    }

    @Override
    public boolean update(Payment entity) {
        String sql = "UPDATE payment SET status = ?::payment_status, " +
                "type = ?::payment_type, receipt_id = ? WHERE id = ?";
        return template.update(sql, entity.getPaymentStatus().toString(),
                entity.getPaymentType().toString(), entity.getPaymentReceiptId(), entity.getId()) == 1;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM payment WHERE id = ?";
        return template.update(sql, id) == 1;
    }
}
