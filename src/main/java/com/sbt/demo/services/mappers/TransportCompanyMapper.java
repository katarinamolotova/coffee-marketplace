package com.sbt.demo.services.mappers;

import com.sbt.demo.repositories.entities.TransportCompany;
import com.sbt.demo.services.dto.TransportCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportCompanyMapper extends AbstractMapper<TransportCompany, TransportCompanyDTO> {

    @Autowired
    TransportCompanyMapper() {
        super(TransportCompany.class, TransportCompanyDTO.class);
    }
}
