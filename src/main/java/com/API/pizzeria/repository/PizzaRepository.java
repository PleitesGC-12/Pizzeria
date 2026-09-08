package com.API.pizzeria.repository;

import com.API.pizzeria.persistence.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    List<Pizza> findAllByAvailableTrueOrderByPrice();

    Pizza findAllByAvailableTrueAndNameIgnoreCase(String name);

    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

}
