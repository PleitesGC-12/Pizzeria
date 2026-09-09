package com.API.pizzeria.repository;

import com.API.pizzeria.persistence.entity.Order;
import com.API.pizzeria.persistence.enums.OrderMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByDateAfter(LocalDateTime date);

    List<Order> findAllByOrderMethodIn(List<OrderMethod> orders);
}
