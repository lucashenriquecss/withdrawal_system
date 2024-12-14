package com.example.withdrawal_system.infraestructure.repository;

import org.springframework.stereotype.Repository;

import com.example.withdrawal_system.domain.model.Order;
import com.example.withdrawal_system.domain.port.output.OrderRepository;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final org.springframework.data.jpa.repository.JpaRepository<Order, Long> repository;

    public JpaOrderRepository(org.springframework.data.jpa.repository.JpaRepository<Order, Long> repository) {
        this.repository = repository;
    }
    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // @Override
    // public Order findByQrCode(String qrCode) {
    //     return repository.findByQrCode(qrCode).orElseThrow(() -> new RuntimeException("Order not found"));
    // }
}