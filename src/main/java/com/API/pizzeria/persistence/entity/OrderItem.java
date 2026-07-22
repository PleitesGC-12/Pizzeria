package com.API.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    @EmbeddedId             // alerts jpa this a composite PK and it is defined inside OrderItemId
    private OrderItemId itemId;

    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, scale = 2, precision = 1)
    private BigDecimal quantity;

    @Column(nullable = false, scale = 5, precision = 2)
    private BigDecimal price;

}
