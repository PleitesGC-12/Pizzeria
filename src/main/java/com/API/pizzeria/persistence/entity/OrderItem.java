package com.API.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@IdClass(OrderItemId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    @Id
    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, scale = 2, precision = 1)
    private BigDecimal quantity;

    @Column(nullable = false, scale = 5, precision = 2)
    private BigDecimal price;

}
