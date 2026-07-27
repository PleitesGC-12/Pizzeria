package com.API.pizzeria.DTO;

import java.math.BigDecimal;

public record PizzaDTO(
        String name,
        String description,
        BigDecimal price,
        Boolean vegetarian,
        Boolean vegan,
        Boolean available
) {
}
