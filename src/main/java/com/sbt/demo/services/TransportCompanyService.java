package com.sbt.demo.services;

import com.sbt.demo.repositories.TransportCompanyRepository;
import com.sbt.demo.repositories.entities.TransportCompany;
import com.sbt.demo.services.dto.TransportCompanyDTO;
import com.sbt.demo.services.mappers.TransportCompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class TransportCompanyService {
    private final TransportCompanyRepository transportCompanyRepository;
    private final TransportCompanyMapper transportCompanyMapper;

    public void saveSetOfTransportCompanies(final Set<TransportCompanyDTO> transportCompanies) {
        transportCompanies.forEach(
                transportCompany -> {
                    final TransportCompany entity = transportCompanyMapper.toModel(transportCompany);
                    transportCompanyRepository.create(
                            entity.getId(),
                            entity.getShortName(),
                            entity.getFullName(),
                            entity.getInn(),
                            entity.getKpp(),
                            entity.getOkpo(),
                            entity.getOgrn(),
                            entity.getAddress()
                    );
                }
        );
    }
}
