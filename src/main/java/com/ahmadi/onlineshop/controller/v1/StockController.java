package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.entity.Stock;
import com.ahmadi.onlineshop.service.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Stock", description = "Operations related to product stock management")
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    private StockService stockService;


    @PostMapping
    public ResponseEntity<Stock> createStock(@Valid  @RequestBody Stock stock) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.createStock(stock));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Stock> getStockByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(stockService.getStockByProductId(productId));
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @Valid @RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.updateStock(id, stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();

    }
}
