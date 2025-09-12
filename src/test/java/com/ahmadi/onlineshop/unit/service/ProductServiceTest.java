package com.ahmadi.onlineshop.unit.service;

import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.exception.ProductNotFoundException;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.service.impl.ProductServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testGetProductById_Found() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        Product result = productService.getProductById(1L);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    void testGetProductById_NotFound() {
        Mockito.when(productRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () ->
                productService.getProductById(99L));
    }
}