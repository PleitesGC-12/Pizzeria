package com.API.pizzeria.mapper.orders;

import com.API.pizzeria.DTO.orders.OrderDTO;
import com.API.pizzeria.persistence.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toDto(Order order);

    List<OrderDTO> toDto(List<Order> orders);
}
