package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    Page<Product> getAllProducts(Pageable pageable);

    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);


    public List<ProductPopularityDto> getTopSellingProducts(int topN) ;



    }
