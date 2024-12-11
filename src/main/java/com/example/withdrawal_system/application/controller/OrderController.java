package com.example.withdrawal_system.application.controller;

import org.springframework.web.bind.annotation.*;

import com.example.withdrawal_system.application.dto.OrderDTO;
import com.example.withdrawal_system.application.mapper.OrderMapper;
import com.example.withdrawal_system.domain.port.input.OrderService;

public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return OrderMapper.toDTO(orderService.createOrder(OrderMapper.toEntity(orderDTO)));
    }

    @PutMapping("/{id}/location")
    public OrderDTO updateOrderLocation(@PathVariable Long id, @RequestParam String location) {
        return OrderMapper.toDTO(orderService.updateOrderLocation(id, location));
    }

    @PostMapping("/pickup")
    public OrderDTO confirmPickup(@RequestParam String qrCode) {
        return OrderMapper.toDTO(orderService.confirmPickup(qrCode));
    }
}
