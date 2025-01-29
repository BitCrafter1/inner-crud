package com.da.innercrud1.mapper;

import com.da.innercrud1.dto.OrderDto;
import com.da.innercrud1.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toModel(OrderDto orderDto);
    void updateOrder(OrderDto orderDto, @MappingTarget Order order);
}