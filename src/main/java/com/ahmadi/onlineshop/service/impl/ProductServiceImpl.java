package com.ahmadi.onlineshop.service.impl;

import com.ahmadi.onlineshop.entity.Category;
import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.repository.CategoryRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
                            orElseThrow(() -> new RuntimeException("category not found"));

                }
            });
        }

        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        existing.getCategories().clear();
        if (product.getCategories() != null) {
            for (Category category : product.getCategories()) {
                Category persistedCategory = categoryRepository.findById(category.getId())
                        .orElseThrow(() -> new RuntimeException("Category not found with id: " + category.getId()));
                existing.getCategories().add(persistedCategory);
            }
        }

        return productRepository.save(existing);
    }


    @Transactional
    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        for (Category category : product.getCategories()) {
            category.getProducts().remove(product);
        }
        product.getCategories().clear();
        productRepository.delete(product);
    }
}

