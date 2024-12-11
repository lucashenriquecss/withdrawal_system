package com.example.withdrawal_system.domain.port.output;

import com.example.withdrawal_system.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
    Order findByQrCode(String qrCode);
}