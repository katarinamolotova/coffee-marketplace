package com.sbt.demo.services;

import com.sbt.demo.repositories.TransportCompanyRepositoryImpl;
import com.sbt.demo.services.dto.TransportCompanyDTO;
import com.sbt.demo.services.mappers.TransportCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportCompanyService {
    private final TransportCompanyRepositoryImpl transportCompanyRepository;
    private final TransportCompanyMapper transportCompanyMapper;

    @Autowired
    public TransportCompanyService(
            TransportCompanyRepositoryImpl transportCompanyRepository,
            TransportCompanyMapper transportCompanyMapper
    ) {
        this.transportCompanyRepository = transportCompanyRepository;
        this.transportCompanyMapper = transportCompanyMapper;
    }

    public void save(TransportCompanyDTO transportCompany) {
        transportCompanyRepository.save(
                transportCompanyMapper.toModel(transportCompany)
        );
    }
}
