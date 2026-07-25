package com.API.pizzeria.service;

import com.API.pizzeria.DTO.PizzaResponseDTO;

import java.util.List;

public interface PizzaService {

    List<PizzaResponseDTO> getAll();
    PizzaResponseDTO getById(Integer id);
}
