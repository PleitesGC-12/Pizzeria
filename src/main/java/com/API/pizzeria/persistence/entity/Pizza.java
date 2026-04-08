package com.API.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pizzas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The id is incremented one by one automatically
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30, unique = true) // There cannot be more than two pizzas with the same name
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, precision = 5, scale = 2) // precision: amount of total digits, scale: decimal precision
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean vegetarian;

    @Column(nullable = false)
    private Boolean vegan;

    @Column(nullable = false)
    private Boolean available;
}
