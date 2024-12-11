package com.example.withdrawal_system.domain.port.input;

import com.example.withdrawal_system.domain.model.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrderLocation(Long orderId, String location);
    Order confirmPickup(String qrCode);
}