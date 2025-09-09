package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
