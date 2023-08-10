package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.Nomenclature;
import com.sbt.demo.services.dto.NomenclatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NomenclatureMapper extends AbstractMapper<Nomenclature, NomenclatureDTO> {

    @Autowired
    NomenclatureMapper() {
        super(Nomenclature.class, NomenclatureDTO.class);
    }
}
