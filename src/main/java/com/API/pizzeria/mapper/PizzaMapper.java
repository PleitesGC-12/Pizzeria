package com.API.pizzeria.mapper;

import com.API.pizzeria.DTO.PizzaResponseDTO;
import com.API.pizzeria.persistence.entity.Pizza;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

    // Converts a list of pizzas into a list of DTO
    List<PizzaResponseDTO> toDto(List<Pizza> pizzas);

    // Converts a a single pizza to a pizza DTO
    PizzaResponseDTO toDto(Pizza pizza);
}
