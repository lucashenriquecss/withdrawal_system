package com.example.withdrawal_system.application.mapper;

import com.example.withdrawal_system.application.dto.OrderDTO;
import com.example.withdrawal_system.domain.model.Order;

public class OrderMapper {
    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setQrCode(order.getQrCode());
        dto.setStatus(order.getStatus());
        dto.setItems(order.getItems());
        dto.setLocation(order.getLocation());
        return dto;
    }

    public static Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setQrCode(dto.getQrCode());
        order.setStatus(dto.getStatus());
        order.setItems(dto.getItems());
        order.setLocation(dto.getLocation());
        return order;
    }
}