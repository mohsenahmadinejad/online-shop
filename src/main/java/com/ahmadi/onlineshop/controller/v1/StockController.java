package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.entity.Stock;
import com.ahmadi.onlineshop.service.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Stock", description = "Operations related to product stock management")
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    private StockService stockService;


    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @GetMapping("/product/{productId}")
    public Stock getStockByProduct(@PathVariable Long productId) {
        return stockService.getStockByProductId(productId);
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
