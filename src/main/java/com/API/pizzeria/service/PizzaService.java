package com.API.pizzeria.service;

import com.API.pizzeria.DTO.PizzaDTO;
import com.API.pizzeria.DTO.UpdatePizzaDTO;

import java.util.List;

public interface PizzaService {

    List<PizzaDTO> getAll();

    PizzaDTO getById(Integer id);

    PizzaDTO save(PizzaDTO pizzaRequestDTO);

    PizzaDTO update(Integer id, UpdatePizzaDTO updateDTO);
}
