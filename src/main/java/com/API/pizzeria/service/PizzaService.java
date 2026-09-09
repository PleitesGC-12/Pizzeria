package com.API.pizzeria.service;

import com.API.pizzeria.DTO.pizzas.PizzaDTO;
import com.API.pizzeria.DTO.pizzas.UpdatePizzaDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PizzaService {

    List<PizzaDTO> getAll();

    PizzaDTO getById(Integer id);

    List<PizzaDTO> getAvailable();

    PizzaDTO getByName(String name);

    List<PizzaDTO> getWith(String ingredient);

    List<PizzaDTO> getWithout(String ingredient);

    List<PizzaDTO> getCheapest(BigDecimal price);

    PizzaDTO save(PizzaDTO pizzaRequestDTO);

    PizzaDTO put(Integer id, UpdatePizzaDTO updateDTO);

    void delete(Integer id);

}
