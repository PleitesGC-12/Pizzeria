package com.API.pizzeria.DTO.pizzas;

public record UpdatePizzaDTO(
        String name,
        String description,
        Boolean vegetarian,
        Boolean vegan
) {
}
