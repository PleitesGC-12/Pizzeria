package com.API.pizzeria.DTO;

import java.math.BigDecimal;

public record PizzaResponseDTO(

        String name,

        String description,

        BigDecimal price,

        Boolean vegetarian,

        Boolean vegan,

        Boolean available
) {
}
