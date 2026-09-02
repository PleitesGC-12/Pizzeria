package com.API.pizzeria.exception;

public class PizzaNotFoundByNameException extends RuntimeException {

    public PizzaNotFoundByNameException(String name) {
        super("Pizza not found with name: " + name);
    }
}
