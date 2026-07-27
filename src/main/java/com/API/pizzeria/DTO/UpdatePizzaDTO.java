package com.API.pizzeria.DTO;

import java.math.BigDecimal;

public record UpdatePizzaDTO(
        String name,
        String description,
        Boolean vegetarian,
        Boolean vegan
) {
}
