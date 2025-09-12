package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.entity.Stock;

import java.util.List;

public interface StockService {
    Stock createStock(Stock stock);
    Stock getStockById(Long id);
    Stock getStockByProductId(Long productId);
    List<Stock> getAllStocks();
    Stock updateStock(Long id, Stock stock);
    void deleteStock(Long id);
    void reduceStock(Long productId, int quantity) ;

    }
