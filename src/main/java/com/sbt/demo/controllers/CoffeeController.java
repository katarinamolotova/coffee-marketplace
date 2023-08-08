package com.sbt.demo.controllers;

import com.sbt.demo.services.CoffeeService;
import com.sbt.demo.exceptions.OrdersParsingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {
    private final CoffeeService service;

    @Autowired
    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getInfoAboutOrders() {
        try {
            return service.getInfoAboutOrders();
        } catch (OrdersParsingException e) {
            return e.getMessage();
        }
    }
}
