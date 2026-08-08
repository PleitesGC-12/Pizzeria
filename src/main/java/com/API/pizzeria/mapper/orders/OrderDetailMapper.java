package com.API.pizzeria.mapper.orders;

import com.API.pizzeria.DTO.orders.OrderDetailDTO;
import com.API.pizzeria.mapper.customers.CustomerMapper;
import com.API.pizzeria.persistence.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        CustomerMapper.class,
        OrderItemDetailMapper.class
})
public interface OrderDetailMapper {
    OrderDetailDTO toDetailDto(Order order);
}
