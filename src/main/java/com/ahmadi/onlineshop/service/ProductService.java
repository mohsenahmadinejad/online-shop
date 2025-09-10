package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);


    public List<ProductPopularityDto> getTopSellingProducts(int topN) ;



    }
