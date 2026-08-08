package com.API.pizzeria.controller;

import com.API.pizzeria.DTO.pizzas.PizzaDTO;
import com.API.pizzeria.DTO.pizzas.UpdatePizzaDTO;
import com.API.pizzeria.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaDTO>> getAll() {
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pizzaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PizzaDTO> postPizza(@RequestBody PizzaDTO pizzaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaService.save(pizzaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDTO> putPizza(@PathVariable Integer id, @RequestBody UpdatePizzaDTO updatePizza) {
        return ResponseEntity.ok( pizzaService.put(id, updatePizza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Integer id) {
        pizzaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
