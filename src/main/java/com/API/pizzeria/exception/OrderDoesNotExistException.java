package com.API.pizzeria.exception;

public class OrderDoesNotExistException extends RuntimeException {

    public OrderDoesNotExistException(Integer id) {
        super("The order with the id: " + id + " does not exist");
    }
}
