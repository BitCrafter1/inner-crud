package com.da.innercrud1.service;

import com.da.innercrud1.dto.OrderDto;
import com.da.innercrud1.exception.OrderNotFoundException;
import com.da.innercrud1.mapper.OrderMapper;
import com.da.innercrud1.model.Order;
import com.da.innercrud1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toModel(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        return orderMapper.toDto(order);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        orderMapper.updateOrder(orderDto, existingOrder);
        Order updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toDto(updatedOrder);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}