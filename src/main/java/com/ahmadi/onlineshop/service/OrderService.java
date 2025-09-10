package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.dto.OrderDto;
import com.ahmadi.onlineshop.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getById(Long id);
    List<Order> getAll();


    public Page<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable) ;
    public Page<Order> findByCustomerId(Long customerId, Pageable pageable) ;
    public Page<Order> findByTotalAmountBetween(Float min, Float max, Pageable pageable) ;


    }
