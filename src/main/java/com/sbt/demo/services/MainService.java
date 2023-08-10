package com.sbt.demo.services;

import com.sbt.demo.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final NomenclatureService nomenclatureService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;
    private final TransportCompanyService transportCompanyService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final StatusHistoryService statusHistoryService;
    private final HandlerJsonService handlerJsonService;

    @Autowired
    public MainService(
            NomenclatureService nomenclatureService,
            PaymentService paymentService,
            DeliveryService deliveryService,
            TransportCompanyService transportCompanyService,
            OrderService orderService,
            OrderItemService orderItemService,
            StatusHistoryService statusHistoryService,
            HandlerJsonService handlerJsonService
    ) {
        this.nomenclatureService = nomenclatureService;
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
        this.transportCompanyService = transportCompanyService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.statusHistoryService = statusHistoryService;
        this.handlerJsonService = handlerJsonService;
    }

    public String getInfoAboutOrders() {
        List<OrderDTO> orders = handlerJsonService.getOrdersFromExternalApi();
        return handlerJsonService.convertOrdersToJson(orders);
    }

    private Set<NomenclatureDTO> getNomenclatureFromOrders(List<OrderDTO> orders) {
        return orders.stream()
                .map(OrderDTO::getOrderItems)
                .flatMap(Collection::stream)
                .map(OrderItemDTO::getNomenclature)
                .collect(Collectors.toSet());
    }

    private Set<TransportCompanyDTO> getTransportCompanyFromOrders(List<OrderDTO> orders) {
        return orders.stream()
                .map(OrderDTO::getOrderDelivery)
                .filter(Objects::nonNull)
                .map(DeliveryDTO::getTransportCompany)
                .collect(Collectors.toSet());
    }

    private List<PaymentDTO> getPaymentFromOrders(List<OrderDTO> orders) {
        return orders.stream()
                .map(OrderDTO::getOrderPayment)
                .collect(Collectors.toList());
    }

    private List<DeliveryDTO> getDeliveryFromOrders(List<OrderDTO> orders) {
        return orders.stream()
                .map(OrderDTO::getOrderDelivery)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Map<Long, List<OrderItemDTO>> getMapOrderIdAndOrderItemsFromOrders(List<OrderDTO> orders) {
        return orders.stream()
                .collect(Collectors.toMap(OrderDTO::getOrderId, OrderDTO::getOrderItems));
    }

    private Map<Long, List<StatusHistoryDTO>> getMapOrderIdAndHistoryStatusFromOrders(List<OrderDTO> orders) {
        return orders.stream()
                .collect(Collectors.toMap(OrderDTO::getOrderId, OrderDTO::getStatusHistory));
    }

    public void saveAllData() {
        List<OrderDTO> orders = handlerJsonService.getOrdersFromExternalApi();

        nomenclatureService.saveSetOfNomenclatures(getNomenclatureFromOrders(orders));
        transportCompanyService.saveSetOfTransportCompanies(getTransportCompanyFromOrders(orders));
        deliveryService.saveListOfDeliveries(getDeliveryFromOrders(orders));
        paymentService.saveListOfPayments(getPaymentFromOrders(orders));
        orderService.saveListOfOrders(orders);
        orderItemService.saveMapOfOrderIdAndOrderItems(getMapOrderIdAndOrderItemsFromOrders(orders));
        statusHistoryService.saveMapOrderIdAndStatusHistory(getMapOrderIdAndHistoryStatusFromOrders(orders));
    }
}
