package com.API.pizzeria.DTO;

public record UpdatePizzaDTO(
        String name,
        String description,
        Boolean vegetarian,
        Boolean vegan
) {
}
