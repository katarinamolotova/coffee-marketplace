package com.sbt.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbt.demo.services.dto.*;
import com.sbt.demo.exceptions.OrdersParsingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@PropertySource("classpath:properties/url.properties")
public class MainService {

    private final String internalUrl;
    private final ObjectMapper objectMapper;

    private final NomenclatureService nomenclatureService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;
    private final TransportCompanyService transportCompanyService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final StatusHistoryService statusHistoryService;

    @Autowired
    public MainService(
            ObjectMapper mapper,
            @Value("${url.base}") String baseUrl,
            @Value("${url.orders}") String ordersUrl,
            NomenclatureService nomenclatureService,
            PaymentService paymentService,
            DeliveryService deliveryService,
            TransportCompanyService transportCompanyService,
            OrderService orderService,
            OrderItemService orderItemService,
            StatusHistoryService statusHistoryService) {
        objectMapper = mapper;
        internalUrl = baseUrl + ordersUrl;

        this.nomenclatureService = nomenclatureService;
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
        this.transportCompanyService = transportCompanyService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.statusHistoryService = statusHistoryService;
    }

    public String getInfoAboutOrders() {
        String response = getJson();
        List<OrderDTO> orders = convertJsonToOrders(response);
        saveAllData(orders);
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

    private void saveAllData(List<OrderDTO> orders) {
        orders.forEach(
                order -> {
                    paymentService.save(order.getOrderPayment());
                    DeliveryDTO d = order.getOrderDelivery();
                    if (d != null) {
                        TransportCompanyDTO tc = order.getOrderDelivery().getTransportCompany();
                        if (tc != null)
                            transportCompanyService.save(tc);
                        deliveryService.save(order.getOrderDelivery());
                    }
                    orderService.save(order);
                    order.getOrderItems().forEach(
                            item -> {
                                nomenclatureService.save(item.getNomenclature());
                                orderItemService.save(item, order);
                            }
                    );
                    order.getStatusHistory().forEach(
                            history -> statusHistoryService.save(history, order)
                    );
                }
        );
    }
}
