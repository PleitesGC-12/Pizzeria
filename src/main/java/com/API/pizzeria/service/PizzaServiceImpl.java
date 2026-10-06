package com.API.pizzeria.service;

import com.API.pizzeria.DTO.pizzas.PizzaDTO;
import com.API.pizzeria.DTO.pizzas.UpdatePizzaDTO;
import com.API.pizzeria.exception.IngredientNotFoundException;
import com.API.pizzeria.exception.PizzaDoesNotExistException;
import com.API.pizzeria.exception.PizzaNotFoundByNameException;
import com.API.pizzeria.mapper.pizzas.PizzaMapper;
import com.API.pizzeria.persistence.entity.Pizza;
import com.API.pizzeria.repository.PizzaPagSortRepository;
import com.API.pizzeria.repository.PizzaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;
    private final PizzaPagSortRepository pizzaPag;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper, PizzaPagSortRepository pizzaPag) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
        this.pizzaPag = pizzaPag;
    }

    @Override
    public Page<PizzaDTO> getAll(Pageable pageable) {
        Page<Pizza> pizzaPage = pizzaPag.findAll(pageable);
        return pizzaPage.map(pizzaMapper::toDto);
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
    public List<PizzaDTO> getAvailable() {
        return pizzaMapper.toDto(pizzaRepository.findAllByAvailableTrueOrderByPrice());
    }

    @Override
    public PizzaDTO getByName(String name) {

        Pizza pizza = pizzaRepository
                .findAllByAvailableTrueAndNameIgnoreCase(name)
                .orElseThrow(() -> new PizzaNotFoundByNameException(name));

        return pizzaMapper.toDto(pizza);
    }

    @Override
    public List<PizzaDTO> getWith(String ingredient) {

        List<Pizza> ingredients = pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);

        if (ingredients.isEmpty()) {
            throw new IngredientNotFoundException(ingredient);
        }

        return pizzaMapper.toDto(ingredients);
    }

    @Override
    public List<PizzaDTO> getWithout(String ingredient) {
        List<Pizza> ingredients = pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
        return pizzaMapper.toDto(ingredients);
    }

    @Override
    public List<PizzaDTO> getCheapest(BigDecimal price) {
        return pizzaMapper.toDto(pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqual(price));
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
