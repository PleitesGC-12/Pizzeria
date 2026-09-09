package com.API.pizzeria.repository;

import com.API.pizzeria.persistence.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    List<Pizza> findAllByAvailableTrueOrderByPrice();

    Optional<Pizza> findAllByAvailableTrueAndNameIgnoreCase(String name);

    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

    List<Pizza> findTop3ByAvailableTrueAndPriceLessThanEqual(BigDecimal price);
}
