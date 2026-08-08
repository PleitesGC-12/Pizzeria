package com.API.pizzeria.controller;

import com.API.pizzeria.DTO.orders.OrderDTO;
import com.API.pizzeria.DTO.orders.OrderDetailDTO;
import com.API.pizzeria.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getById(id));
    }
}
