package com.sbt.demo.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sbt.demo.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDTO {

    @JsonProperty("orderDeliveryId")
    private Long id;
    private TransportCompanyDTO transportCompany;

    @JsonProperty("orderDeliveryStatus")
    private DeliveryStatus deliveryStatus;
    private String address;
}
