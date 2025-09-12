package com.ahmadi.onlineshop.unit.controller.v1;


import com.ahmadi.onlineshop.controller.v1.ProductController;
import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest {

    private MockMvc mockMvc;
    private ProductService productService;
    private ProductController productController;
    private ObjectMapper objectMapper;

    private Product product;
    private ProductPopularityDto popularityDto;

    @BeforeEach
    void setup() {
        productService = Mockito.mock(ProductService.class);
        productController = new ProductController(productService);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();

        // نمونه Product
        product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        product.setPrice(1000.0);

        // نمونه ProductPopularityDto
        popularityDto = new ProductPopularityDto(1L, 50L); // productId, totalSold
    }

    @Test
    void testGetTopSellingProducts() throws Exception {
        Mockito.when(productService.getTopSellingProducts(anyInt()))
                .thenReturn(List.of(popularityDto));

        mockMvc.perform(get("/api/v1/products/top-selling")
                        .param("topN", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(1))
                .andExpect(jsonPath("$[0].totalSold").value(50));
    }


    @Test
    void testGetProductById() throws Exception {
        Mockito.when(productService.getProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/api/v1/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void testGetAllProducts() throws Exception {
        Mockito.when(productService.getAllProducts()).thenReturn(List.of(product));

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }


    @Test
    void testDeleteProduct() throws Exception {
        Mockito.doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/v1/products/1"))
                .andExpect(status().isOk());
    }
}