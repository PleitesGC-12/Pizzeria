package com.API.pizzeria.repository;

import com.API.pizzeria.persistence.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
