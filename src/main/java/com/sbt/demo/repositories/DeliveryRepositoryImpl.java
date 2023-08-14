package com.sbt.demo.repositories;

import com.sbt.demo.config.ApplicationConfig;
import com.sbt.demo.repositories.entities.Delivery;
import com.sbt.demo.repositories.mappers.DeliveryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryRepositoryImpl implements CrudRepository<Delivery> {
    private final JdbcTemplate template;

    @Autowired
    DeliveryRepositoryImpl(ApplicationConfig config) {
        this.template = config.jdbcTemplate();
    }

    @Override
    public Delivery findById(Long id) {
        String sql = "SELECT * FROM delivery WHERE id = ?";
        return template.query(sql, new Object[] { id }, new DeliveryRowMapper())
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Delivery> findAll() {
        String sql = "SELECT * FROM delivery";
        return template.query(sql, new DeliveryRowMapper());
    }

    @Override
    public boolean save(Delivery entity) {
        String sql = "INSERT INTO delivery VALUES (?, ?, ?::delivery_status, ?)";
        if (findById(entity.getId()) != null)
            return false;
        return template.update(sql, entity.getId(), entity.getTransportCompanyId(),
                entity.getDeliveryStatus().toString(), entity.getAddress()) == 1;
    }

    @Override
    public boolean update(Delivery entity) {
        String sql = "UPDATE delivery SET transport_company_id = ?, " +
                "status = ?::delivery_status, address = ? WHERE id = ?";
        return template.update(sql, entity.getTransportCompanyId(),
                entity.getDeliveryStatus().toString(), entity.getAddress(), entity.getId()) == 1;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM delivery WHERE id = ?";
        return template.update(sql, id) == 1;
    }
}
