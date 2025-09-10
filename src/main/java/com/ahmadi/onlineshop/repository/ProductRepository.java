package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    Order findByName(String name );


    Page<Product> findByNameContainingIgnoreCaseAndStockQuantityGreaterThan(
            String name, int stockQuantity, Pageable pageable
    );

    Page<Product> findByCategoriesIdAndStockQuantityGreaterThan(
            Long categoryId, int stockQuantity, Pageable pageable
    );

    Page<Product> findByNameContainingIgnoreCaseAndCategoriesIdAndStockQuantityGreaterThan(
            String name, Long categoryId, int stockQuantity, Pageable pageable
    );

    @Query("SELECT new com.ahmadi.onlineshop.dto.ProductPopularityDto(i.product.id, SUM(i.quantity)) " +
            "FROM OrderItem i GROUP BY i.product.id ORDER BY SUM(i.quantity) DESC")
    List<ProductPopularityDto> findTopSellingProducts(Pageable pageable);
}
