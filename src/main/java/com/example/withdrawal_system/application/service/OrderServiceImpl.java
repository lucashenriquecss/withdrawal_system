package com.example.withdrawal_system.application.service;

import org.springframework.stereotype.Service;

import com.example.withdrawal_system.domain.model.Order;
import com.example.withdrawal_system.domain.port.input.OrderService;
import com.example.withdrawal_system.domain.port.output.OrderRepository;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        order.setStatus("Aguardando preenchimento");
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrderLocation(Long orderId, String location) {
        Order order = orderRepository.findById(orderId);
        order.setLocation(location);
        order.setStatus("Pronto para retirada");
        return orderRepository.save(order);
    }

    @Override
    public Order confirmPickup(String qrCode) {
        Order order = orderRepository.findByQrCode(qrCode);
        order.setStatus("Concluído");
        return orderRepository.save(order);
    }
}
