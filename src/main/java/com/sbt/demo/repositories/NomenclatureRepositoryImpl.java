package com.sbt.demo.repositories;

import com.sbt.demo.config.SocketsApplicationConfig;
import com.sbt.demo.models.Nomenclature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NomenclatureRepositoryImpl implements CrudRepository<Nomenclature> {

    private final JdbcTemplate template;
    private final String tableName = "nomenclature";

    @Autowired
    NomenclatureRepositoryImpl(SocketsApplicationConfig config) {
        this.template = config.jdbcTemplate();
    }


    @Override
    public Nomenclature findById(Long id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        return template.query(sql, new Object[] { id }, new NomenclatureRawMapper())
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Nomenclature> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return template.query(sql, new NomenclatureRawMapper());
    }

    @Override
    public boolean save(Nomenclature entity) {
        String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?, ?, ?)";
        if (findById(entity.getId()) != null)
            return false;
        return template.update(sql, entity.getId(), entity.getName(), entity.getDescription(),
                entity.getAcidity(), entity.getDensity(), entity.getPrice()) == 1;
    }

    @Override
    public boolean update(Nomenclature entity) {
        String sql = "UPDATE " + tableName + " SET name = ?, description = ?," +
                "acidity = ?, density = ?, price = ? WHERE id = ?";
        return template.update(sql, entity.getName(), entity.getDescription(),
                entity.getAcidity(), entity.getDensity(), entity.getPrice(), entity.getId()) == 1;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        return template.update(sql, id) == 1;
    }
}
