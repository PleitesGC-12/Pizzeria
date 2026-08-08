package com.API.pizzeria.DTO.orders;

import com.API.pizzeria.DTO.pizzas.PizzaSummaryDTO;

import java.math.BigDecimal;

/* This DTO is used by the OrderDetailDTO because it contains the orderItem
field and as we don't want to show all of its fields we use this dTO
 */
public record OrderItemDetailDTO(
        Integer itemId,
        Integer quantity,
        BigDecimal price,
        PizzaSummaryDTO pizza
) {
}