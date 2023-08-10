package com.sbt.demo.exceptions;

public class OrdersParsingException extends RuntimeException {
    public OrdersParsingException() {
        super("Ошибка во время обработки данных");
    }
}
