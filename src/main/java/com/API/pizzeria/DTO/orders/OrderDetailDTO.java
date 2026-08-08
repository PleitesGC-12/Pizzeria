package com.API.pizzeria.DTO.orders;

import com.API.pizzeria.DTO.customer.CustomerSummaryDTO;
import com.API.pizzeria.persistence.enums.OrderMethod ;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// This DTO is used by the getId enpoint
public record OrderDetailDTO(
        String idOrder,

        LocalDateTime date,

        BigDecimal total,

        OrderMethod orderMethod,

        String additionalNotes,

        // Returns a customerDTO because we don't want to show all of its fields
        CustomerSummaryDTO customer,

        // Returns a OrderItemDetailDTO because we don't want to show all of its fields
        List<OrderItemDetailDTO> items
) {
}
