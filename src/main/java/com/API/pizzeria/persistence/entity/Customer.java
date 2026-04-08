package com.API.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
// We didn't include any strategy because we are going to define the customer id
    @Id
    @Column(name = "customer_id", length = 15, nullable = false)
    private String customerId;

    @Column(name = "customer_name" , nullable = false, length = 60)
    private String customerName;

    @Column(length = 100) // it can be null if the order is not for delivery
    private String address;

    // Email must be unique for each client
    @Column(length = 50, nullable = false, unique = true) // taking into consideration the electronic facturation
    private String email;

    @Column(name = "phone_number" , length = 20)
    private String phoneNumber;
}
