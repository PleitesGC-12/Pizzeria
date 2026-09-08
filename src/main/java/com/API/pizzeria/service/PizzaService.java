package com.API.pizzeria.service;

import com.API.pizzeria.DTO.pizzas.PizzaDTO;
import com.API.pizzeria.DTO.pizzas.UpdatePizzaDTO;

import java.util.List;

public interface PizzaService {

    List<PizzaDTO> getAll();

    PizzaDTO getById(Integer id);

    List<PizzaDTO> getAvailable();

    PizzaDTO getByName(String name);

    List<PizzaDTO> getWith(String ingredient);

    List<PizzaDTO> getWithout(String ingredient);

    PizzaDTO save(PizzaDTO pizzaRequestDTO);

    PizzaDTO put(Integer id, UpdatePizzaDTO updateDTO);

    void delete(Integer id);

}
