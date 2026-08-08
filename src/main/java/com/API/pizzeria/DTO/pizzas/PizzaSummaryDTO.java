package com.API.pizzeria.DTO.pizzas;

import java.math.BigDecimal;

public record PizzaSummaryDTO(
        Integer idPizza,
        String name,
        BigDecimal price
) {
}
