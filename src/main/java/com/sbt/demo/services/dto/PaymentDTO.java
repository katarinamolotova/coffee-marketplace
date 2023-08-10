package com.sbt.demo.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sbt.demo.enums.PaymentStatus;
import com.sbt.demo.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO {

    @JsonProperty("orderPaymentId")
    private Long id;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private String paymentReceiptId;
}
