package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByProductId(Long productId);


}
