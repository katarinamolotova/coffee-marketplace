package com.sbt.demo.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportCompany {
    private Long id;
    private String shortName;
    private String fullName;
    private String inn;
    private String kpp;
    private String okpo;
    private String ogrn;
    private String address;
}
