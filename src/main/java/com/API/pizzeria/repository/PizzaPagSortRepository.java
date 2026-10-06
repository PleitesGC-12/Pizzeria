package com.API.pizzeria.repository;

import com.API.pizzeria.persistence.entity.Pizza;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<Pizza, Integer>{
}
