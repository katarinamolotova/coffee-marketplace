package com.sbt.demo.repositories;

import com.sbt.demo.config.ApplicationConfig;
import com.sbt.demo.repositories.entities.TransportCompany;
import com.sbt.demo.repositories.mappers.TransportCompanyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportCompanyRepositoryImpl implements CrudRepository<TransportCompany> {
    private final JdbcTemplate template;
    private final String tableName = "transport_company";

    @Autowired
    TransportCompanyRepositoryImpl(ApplicationConfig config) {
        this.template = config.jdbcTemplate();
    }

    @Override
    public TransportCompany findById(Long id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        return template.query(sql, new Object[] { id }, new TransportCompanyRowMapper())
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<TransportCompany> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return template.query(sql, new TransportCompanyRowMapper());
    }

    @Override
    public boolean save(TransportCompany entity) {
        String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        if (findById(entity.getId()) != null)
            return false;
        return template.update(sql, entity.getId(), entity.getShortName(),
                entity.getFullName(), entity.getInn(), entity.getKpp(),
                entity.getOkpo(), entity.getOgrn(), entity.getAddress()) == 1;
    }

    @Override
    public boolean update(TransportCompany entity) {
        String sql = "UPDATE " + tableName + " SET short_name = ?, " +
                "full_name = ?, inn = ?, kpp = ?, okpo = ?, ogrn = ?, " +
                "address = ? WHERE id = ?";
        return template.update(sql, entity.getShortName(), entity.getFullName(),
                entity.getInn(), entity.getKpp(), entity.getOkpo(),
                entity.getOgrn(), entity.getAddress(), entity.getId()) == 1;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        return template.update(sql, id) == 1;
    }
}
