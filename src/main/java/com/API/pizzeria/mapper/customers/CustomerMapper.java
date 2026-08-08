package com.API.pizzeria.mapper.customers;

import com.API.pizzeria.DTO.customer.CustomerSummaryDTO;
import com.API.pizzeria.persistence.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerSummaryDTO toSummaryDto(Customer customer);
}
