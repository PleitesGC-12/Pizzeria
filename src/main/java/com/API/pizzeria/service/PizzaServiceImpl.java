package com.API.pizzeria.service;

import com.API.pizzeria.DTO.pizzas.PizzaDTO;
import com.API.pizzeria.DTO.pizzas.UpdatePizzaDTO;
import com.API.pizzeria.exception.PizzaDoesNotExistException;
import com.API.pizzeria.mapper.pizzas.PizzaMapper;
import com.API.pizzeria.persistence.entity.Pizza;
import com.API.pizzeria.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    @Override
    public List<PizzaDTO> getAll() {
        return pizzaMapper.toDto(pizzaRepository.findAll());
    }

    @Override
    public PizzaDTO getById(Integer id) {

        Pizza pizza = pizzaRepository.findById(id).orElse(null);

        if (pizza == null) {
            throw new PizzaDoesNotExistException(id);
        }

        return pizzaMapper.toDto(pizza);
    }

    @Override
    public PizzaDTO save(PizzaDTO pizzaRequestDTO) {

        Pizza pizza = pizzaMapper.toEntity(pizzaRequestDTO);

        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDTO put(Integer id, UpdatePizzaDTO updateDTO) {

        Pizza pizza = pizzaRepository.findById(id).orElse(null);

        if (pizza == null) throw new PizzaDoesNotExistException(id);

        pizza.setName(updateDTO.name());
        pizza.setDescription(updateDTO.description());
        pizza.setVegetarian(updateDTO.vegetarian());
        pizza.setVegan(updateDTO.vegan());

        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public void delete(Integer id) {

        if (!pizzaRepository.existsById(id)) {
            throw new PizzaDoesNotExistException(id);
        }

        pizzaRepository.deleteById(id);
    }

}
