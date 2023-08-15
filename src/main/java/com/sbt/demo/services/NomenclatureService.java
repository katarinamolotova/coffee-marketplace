package com.sbt.demo.services;


import com.sbt.demo.repositories.NomenclatureRepository;
import com.sbt.demo.repositories.entities.Nomenclature;
import com.sbt.demo.services.dto.NomenclatureDTO;
import com.sbt.demo.services.mappers.NomenclatureMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class NomenclatureService {

    private final NomenclatureRepository nomenclatureRepository;
    private final NomenclatureMapper nomenclatureMapper;

    public void saveSetOfNomenclatures(final Set<NomenclatureDTO> nomenclatures) {
        nomenclatures.forEach(
                nomenclature -> {
                    final Nomenclature entity = nomenclatureMapper.toModel(nomenclature);
                    nomenclatureRepository.create(
                            entity.getId(),
                            entity.getName(),
                            entity.getDescription(),
                            entity.getAcidity(),
                            entity.getDensity(),
                            entity.getPrice()
                    );
                }
        );
    }
}
