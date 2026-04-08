package com.API.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pizza_orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @Column(name = "customer_id", nullable = false, length = 15)
    private String idCustomer; // is not unique because a client can place multiple orders

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal total;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Saves in the DB a String
    private OrderMethod orderMethod;

    // it can be null sometimes if a client does not specify anything else
    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

}
