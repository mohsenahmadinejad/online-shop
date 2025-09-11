package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.entity.Stock;
import com.ahmadi.onlineshop.exception.StockNotFoundException;
import com.ahmadi.onlineshop.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;


    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + id));
    }

    @Override
    public Stock getStockByProductId(Long productId) {
        return stockRepository.findByProductId(productId).orElse(null);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existing = getStockById(id);
        existing.setQuantity(stock.getQuantity());
        return stockRepository.save(existing);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
