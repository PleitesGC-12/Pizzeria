package com.API.pizzeria.service;

import com.API.pizzeria.DTO.orders.OrderDTO;
import com.API.pizzeria.DTO.orders.OrderDetailDTO;
import com.API.pizzeria.exception.OrderDoesNotExistException;
import com.API.pizzeria.mapper.orders.OrderDetailMapper;
import com.API.pizzeria.mapper.orders.OrderMapper;
import com.API.pizzeria.persistence.entity.Order;
import com.API.pizzeria.persistence.enums.OrderMethod;
import com.API.pizzeria.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Override
    public List<OrderDTO> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return orderMapper.toDto(orderRepository.findAllByDateAfter(today));
    }

    @Override
    public List<OrderDTO> getDeliveryAndPickupOrders() {
        List<OrderMethod> orderMethods = List.of(OrderMethod.DELIVERY, OrderMethod.PICKUP);
        return orderMapper.toDto(orderRepository.findAllByOrderMethodIn(orderMethods));
    }
}
