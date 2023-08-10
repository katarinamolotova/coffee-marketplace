package com.sbt.demo.services;


import com.sbt.demo.repositories.NomenclatureRepositoryImpl;
import com.sbt.demo.services.dto.NomenclatureDTO;
import com.sbt.demo.services.mappers.NomenclatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NomenclatureService {

    private final NomenclatureRepositoryImpl nomenclatureRepository;
    private final NomenclatureMapper nomenclatureMapper;

    @Autowired
    public NomenclatureService(
            NomenclatureRepositoryImpl nomenclatureRepository,
            NomenclatureMapper nomenclatureMapper
    ) {
        this.nomenclatureRepository = nomenclatureRepository;
        this.nomenclatureMapper = nomenclatureMapper;
    }

    public void saveSetOfNomenclatures(Set<NomenclatureDTO> nomenclatures) {
        nomenclatures.forEach(
                nomenclature -> nomenclatureRepository.save(nomenclatureMapper.toModel(nomenclature))
        );
    }
}
