package com.sbt.demo.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("transport_company")
public class TransportCompany {

    @Id
    @Column("id")
    private Long id;

    @Column("short_name")
    private String shortName;

    @Column("full_name")
    private String fullName;

    @Column("inn")
    private String inn;

    @Column("kpp")
    private String kpp;

    @Column("okpo")
    private String okpo;

    @Column("ogrn")
    private String ogrn;

    @Column("address")
    private String address;
}
