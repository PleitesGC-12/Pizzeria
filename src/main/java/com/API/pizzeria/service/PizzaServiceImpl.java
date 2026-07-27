package com.API.pizzeria.service;

import com.API.pizzeria.DTO.PizzaDTO;
import com.API.pizzeria.exception.PizzaDoesNotExistException;
import com.API.pizzeria.mapper.PizzaMapper;
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
}
