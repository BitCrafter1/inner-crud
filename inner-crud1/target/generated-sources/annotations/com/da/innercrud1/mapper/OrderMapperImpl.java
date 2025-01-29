package com.da.innercrud1.mapper;

import com.da.innercrud1.dto.OrderDto;
import com.da.innercrud1.model.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T16:00:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto.OrderDtoBuilder orderDto = OrderDto.builder();

        orderDto.id( order.getId() );
        orderDto.quantity( order.getQuantity() );

        return orderDto.build();
    }

    @Override
    public Order toModel(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDto.getId() );
        order.setQuantity( orderDto.getQuantity() );

        return order;
    }

    @Override
    public void updateOrder(OrderDto orderDto, Order order) {
        if ( orderDto == null ) {
            return;
        }

        order.setId( orderDto.getId() );
        order.setQuantity( orderDto.getQuantity() );
    }
}
