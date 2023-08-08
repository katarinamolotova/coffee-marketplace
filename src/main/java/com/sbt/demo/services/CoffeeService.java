package com.sbt.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbt.demo.repositories.NomenclatureRepositoryImpl;
import com.sbt.demo.services.dto.OrderDTO;
import com.sbt.demo.exceptions.OrdersParsingException;
import com.sbt.demo.services.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@PropertySource("classpath:properties/url.properties")
public class CoffeeService {

    private final String internalUrl;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoffeeService(
            ObjectMapper mapper,
            NomenclatureRepositoryImpl nomenclatureRepository,
            @Value("${url.base}") String baseUrl,
            @Value("${url.orders}") String ordersUrl
    ) {
        objectMapper = mapper;
        internalUrl = baseUrl + ordersUrl;
    }

    public String getInfoAboutOrders() {
        String response = getJson();
        List<OrderDTO> orders = convertJsonToOrders(response);
        return convertOrdersToJson(orders);
    }

    private String getJson() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(internalUrl, String.class);
        return response.getBody();
    }

    private List<OrderDTO> convertJsonToOrders(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<List<OrderDTO>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new OrdersParsingException();
        }
    }

    private String convertOrdersToJson(List<OrderDTO> orders) {
        try {
            return objectMapper.writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new OrdersParsingException();
        }
    }
}
