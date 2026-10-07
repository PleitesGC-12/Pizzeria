package com.API.pizzeria.service;

import com.API.pizzeria.DTO.pizzas.PizzaDTO;
import com.API.pizzeria.DTO.pizzas.UpdatePizzaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface PizzaService {

    Page<PizzaDTO> getAll(int pageNumber, int pageSize );

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
