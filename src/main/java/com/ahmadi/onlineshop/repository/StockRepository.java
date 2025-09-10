package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {

    Stock findByProductId(Long productId);


}
