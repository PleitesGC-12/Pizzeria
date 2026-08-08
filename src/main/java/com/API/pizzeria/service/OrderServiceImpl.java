package com.API.pizzeria.service;

import com.API.pizzeria.DTO.orders.OrderDTO;
import com.API.pizzeria.DTO.orders.OrderDetailDTO;
import com.API.pizzeria.exception.OrderDoesNotExistException;
import com.API.pizzeria.mapper.orders.OrderDetailMapper;
import com.API.pizzeria.mapper.orders.OrderMapper;
import com.API.pizzeria.persistence.entity.Order;
import com.API.pizzeria.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, OrderDetailMapper orderDetailMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderDetailMapper = orderDetailMapper;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    public OrderDetailDTO getById(Integer id) {
        Order order = orderRepository.findById(id).orElse(null);

        if (order == null) throw new OrderDoesNotExistException(id);

        return orderDetailMapper.toDetailDto(order);
    }

}
