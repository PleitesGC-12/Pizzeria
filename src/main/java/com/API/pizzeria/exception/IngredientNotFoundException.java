package com.API.pizzeria.exception;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException(String ingredient) {
        super("No pizza was found with the ingredient {" + ingredient + "}");
    }
}
