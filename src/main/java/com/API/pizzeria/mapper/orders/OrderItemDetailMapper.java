package com.API.pizzeria.mapper.orders;

import com.API.pizzeria.DTO.orders.OrderItemDetailDTO;
import com.API.pizzeria.mapper.pizzas.PizzaMapper;
import com.API.pizzeria.persistence.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PizzaMapper.class)
public interface OrderItemDetailMapper {

    OrderItemDetailDTO toItemDetailDTO(OrderItem orderItem);

    List<OrderItemDetailDTO> toDetailDto(List<OrderItem> orderItems);
}
