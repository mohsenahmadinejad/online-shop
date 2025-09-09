package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
