package com.API.pizzeria.mapper;

import com.API.pizzeria.DTO.PizzaDTO;
import com.API.pizzeria.persistence.entity.Pizza;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

    // Converts a list of pizzas into a list of DTO
    List<PizzaDTO> toDto(List<Pizza> pizzas);

    // Converts a single pizza to a pizza DTO
    PizzaDTO toDto(Pizza pizza);

    @InheritInverseConfiguration
    Pizza toEntity(PizzaDTO pizzaDTO);

}
