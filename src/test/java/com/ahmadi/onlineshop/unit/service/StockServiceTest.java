package com.ahmadi.onlineshop.unit.service;

import com.ahmadi.onlineshop.entity.Stock;
import com.ahmadi.onlineshop.exception.InsufficientStockException;
import com.ahmadi.onlineshop.repository.StockRepository;
import com.ahmadi.onlineshop.service.impl.StockServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @Test
    void testReduceStock_Success() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setQuantity(10);

        Mockito.when(stockRepository.findByProductId(1L))
                .thenReturn(Optional.of(stock));

        stockService.reduceStock(1L, 3);

        assertEquals(7, stock.getQuantity());
        Mockito.verify(stockRepository).save(stock);
    }

    @Test
    void testReduceStock_NotEnough() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setQuantity(2);

        Mockito.when(stockRepository.findByProductId(1L))
                .thenReturn(Optional.of(stock));

        assertThrows(InsufficientStockException.class, () ->
                stockService.reduceStock(1L, 5));
    }
}
