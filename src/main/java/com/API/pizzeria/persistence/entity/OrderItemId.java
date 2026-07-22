package com.API.pizzeria.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "order_id")
    private Integer orderId;
}
