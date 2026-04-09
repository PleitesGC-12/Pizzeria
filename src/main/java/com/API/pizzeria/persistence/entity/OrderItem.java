package com.API.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
// There's a bug in the relationships in the diagram from PostgreSQL
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

    // According to the conventions, relationships must be declared at the end
    @OneToOne // One to one relationship, one orderitem can only contain one pizza
    @JoinColumn(name = "id_pizza", insertable = false, updatable = false) // Specify which column allows the relation
    private Pizza pizza;

    // To meet the Single Responsibility Principle, we add insertable and updatable as false
    // de esa forma a traves de esta relacion no se inserten ni actualizen pizzas
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
}
