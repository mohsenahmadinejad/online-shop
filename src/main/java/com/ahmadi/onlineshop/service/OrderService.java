package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.dto.OrderDto;
import com.ahmadi.onlineshop.entity.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getById(Long id);
    List<Order> getAll();

}
