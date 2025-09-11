package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Product", description = "Operations related to products")
@RestController()
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private  ProductService productService;


    @GetMapping("/top-selling")
    @Operation(
            summary = "Get top selling products",
            description = "Find products with the highest total sales based on OrderItems"
    )
    public List<ProductPopularityDto> getTopSelling(@RequestParam(defaultValue = "10") int topN) {
        return productService.getTopSellingProducts(topN);
    }


    @PostMapping
    @Operation(summary = "Create a new product", description = "Add a new product to the system")
    public Product createProduct(@Valid  @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Fetch a single product by its unique ID")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @GetMapping
    @Operation(summary = "Get all products", description = "Fetch all products ")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product", description = "Update product details by ID")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product", description = "Delete a product by its ID")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
