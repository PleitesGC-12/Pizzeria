package com.API.pizzeria.controller;

import com.API.pizzeria.DTO.PizzaResponseDTO;
import com.API.pizzeria.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaResponseDTO>> getAll() {
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByid(@PathVariable Integer id) {
        PizzaResponseDTO pizzaDTO = pizzaService.getById(id);

        if (pizzaDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The movie with the id: " + id + " was not found");
        }

        return ResponseEntity.ok(pizzaDTO);
    }
}
