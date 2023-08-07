package com.sbt.demo;

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
    public String getInfo() {
        try {
            return service.getInfoAboutOrders();
        } catch (OrdersParsingException e) {
            return e.getMessage();
        }
    }
}
