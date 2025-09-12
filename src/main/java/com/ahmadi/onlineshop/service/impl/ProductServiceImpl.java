package com.ahmadi.onlineshop.service.impl;

import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Category;
import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.exception.CategoryNotFoundException;
import com.ahmadi.onlineshop.exception.CustomerNotFoundException;
import com.ahmadi.onlineshop.exception.ProductNotFoundException;
import com.ahmadi.onlineshop.repository.CategoryRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public Product createProduct(Product product) {
        if(product.getCategories()!=null){
            product.getCategories().forEach(category -> {
                if (category.getId()!=null){
                    category=categoryRepository.findById(category.getId()).
                            orElseThrow(() -> new CategoryNotFoundException("category not found"));

                }
            });
        }

        return productRepository.save(product);
    }

    @Override
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("asdf"));
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional
    @CachePut(value = "product",key = "#updatedCustomer.id")
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        existing.getCategories().clear();
        if (product.getCategories() != null) {
            for (Category category : product.getCategories()) {
                Category persistedCategory = categoryRepository.findById(category.getId())
                        .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + category.getId()));
                existing.getCategories().add(persistedCategory);
            }
        }

        return productRepository.save(existing);
    }


    @Transactional
    @Override
    @CacheEvict(value = "product" , key = "#id")
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        for (Category category : product.getCategories()) {
            category.getProducts().remove(product);
        }
        product.getCategories().clear();
        productRepository.delete(product);
    }

    @Override
    public List<ProductPopularityDto> getTopSellingProducts(int topN) {
        Pageable pageable = PageRequest.of(0, topN);
        return productRepository.findTopSellingProducts(pageable);
    }
}

