package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.dto.ProductPopularityDto;
import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Product", description = "Operations related to products")
@RestController()
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final   ProductService productService;


    @GetMapping("/top-selling")
    @Operation(
            summary = "Get top selling products",
            description = "Find products with the highest total sales based on OrderItems"
    )
    public ResponseEntity<List<ProductPopularityDto>> getTopSelling(@RequestParam(defaultValue = "10") int topN) {
        return ResponseEntity.ok(productService.getTopSellingProducts(topN));
    }


    @PostMapping
    @Operation(summary = "Create a new product", description = "Add a new product to the system")
    public ResponseEntity<Product> createProduct(@Valid  @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Fetch a single product by its unique ID")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @GetMapping
    @Operation(summary = "Get all products", description = "Fetch all products ")
    public ResponseEntity<Page<Product>> listAllProducts(
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product", description = "Update product details by ID")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product", description = "Delete a product by its ID")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
