package com.sbt.demo.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportCompanyDTO {

    @JsonProperty("transportCompanyId")
    private Long id;
    private String shortName;
    private String fullName;
    private String inn;
    private String kpp;
    private String okpo;
    private String ogrn;
    private String address;
}
