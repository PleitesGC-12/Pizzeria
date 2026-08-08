package com.API.pizzeria.service;

import com.API.pizzeria.DTO.orders.OrderDTO;
import com.API.pizzeria.DTO.orders.OrderDetailDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAll();

    OrderDetailDTO getById(Integer id);
}
