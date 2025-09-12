package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end,  Pageable pageable );

    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

    Page<Order> findByTotalAmountBetween(Double min, Double max, Pageable pageable);


}
