package com.API.pizzeria.exception;

public class PizzaDoesNotExistException extends RuntimeException {

    public PizzaDoesNotExistException(Integer idPizza) {
        super("The pizza with the id: " + idPizza + " does not exist");
    }
}
