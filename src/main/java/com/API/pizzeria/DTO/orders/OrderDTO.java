package com.API.pizzeria.DTO.orders;

import com.API.pizzeria.persistence.enums.OrderMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// This DTO is used by the getAll endpoint
public record OrderDTO(
    String idOrder,

    String idCustomer,

    LocalDateTime date,

    BigDecimal total,

    OrderMethod orderMethod,

    String additionalNotes
) {
}
