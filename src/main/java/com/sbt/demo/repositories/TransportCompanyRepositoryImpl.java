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

    @Autowired
    TransportCompanyRepositoryImpl(ApplicationConfig config) {
        this.template = config.jdbcTemplate();
    }

    @Override
    public TransportCompany findById(Long id) {
        String sql = "SELECT * FROM transport_company WHERE id = ?";
        return template.query(sql, new Object[] { id }, new TransportCompanyRowMapper())
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<TransportCompany> findAll() {
        String sql = "SELECT * FROM transport_company";
        return template.query(sql, new TransportCompanyRowMapper());
    }

    @Override
    public boolean save(TransportCompany entity) {
        String sql = "INSERT INTO transport_company VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        if (findById(entity.getId()) != null)
            return false;
        return template.update(sql, entity.getId(), entity.getShortName(),
                entity.getFullName(), entity.getInn(), entity.getKpp(),
                entity.getOkpo(), entity.getOgrn(), entity.getAddress()) == 1;
    }

    @Override
    public boolean update(TransportCompany entity) {
        String sql = "UPDATE transport_company SET short_name = ?, " +
                "full_name = ?, inn = ?, kpp = ?, okpo = ?, ogrn = ?, " +
                "address = ? WHERE id = ?";
        return template.update(sql, entity.getShortName(), entity.getFullName(),
                entity.getInn(), entity.getKpp(), entity.getOkpo(),
                entity.getOgrn(), entity.getAddress(), entity.getId()) == 1;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM transport_company WHERE id = ?";
        return template.update(sql, id) == 1;
    }
}
