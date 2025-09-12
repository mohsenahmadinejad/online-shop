package com.ahmadi.onlineshop.service.impl;

import com.ahmadi.onlineshop.dto.OrderDto;
import com.ahmadi.onlineshop.entity.*;
import com.ahmadi.onlineshop.exception.CustomerNotFoundException;
import com.ahmadi.onlineshop.exception.InsufficientStockException;
import com.ahmadi.onlineshop.exception.ProductNotFoundException;
import com.ahmadi.onlineshop.exception.StockNotFoundException;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.repository.OrderRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.repository.StockRepository;
import com.ahmadi.onlineshop.service.OrderService;
import com.ahmadi.onlineshop.service.StockService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    private final StockRepository stockRepository;
    private final StockService stockService;

    private static final int MAX_RETRIES = 3;

    @Override
    public Order createOrder(Order order) {
        int attempts = 0;
        while (true) {
            try {
                return tryCreateOrder(order);
            } catch (OptimisticLockingFailureException ex) {
                attempts++;
                if (attempts >= MAX_RETRIES) {
                    throw new RuntimeException("Could not complete order due to concurrent stock updates, please try again.");
                }

            }
        }
    }


    @Transactional
    public Order tryCreateOrder(Order order) {
        Customer customer=customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not found"));


        order.getOrderItems().forEach(orderItem -> {
            Product product=productRepository.findById(orderItem.getProduct().getId()).
                    orElseThrow(() -> new ProductNotFoundException("Product not found"));

            Stock stock = stockRepository.findByProductId(product.getId())
                    .orElseThrow(() -> new StockNotFoundException("Stock not found for product " + product.getId()));


            stockService.reduceStock(orderItem.getId(),orderItem.getQuantity());

//            if (stock.getQuantity() < orderItem.getQuantity()) {
//                throw new InsufficientStockException(product.getId(), stock.getQuantity(), orderItem.getQuantity());
//            }
//            stock.setQuantity(stock.getQuantity() - orderItem.getQuantity());
//            stockRepository.save(stock);

            orderItem.setOrder(order);
            orderItem.setPrice(product.getPrice()*orderItem.getQuantity());


        });

        var totalAmount=order.getOrderItems().stream().mapToDouble(OrderItem::getPrice).sum();
        order.setTotalAmount(totalAmount);

        order.setOrderDate(LocalDateTime.now());
        if(order.getShippingAddress()!=null){
            order.getShippingAddress().setOrder(order);
        }

        return orderRepository.save(order);

    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable) {
        return orderRepository.findByOrderDateBetween(start, end, pageable);
    }

    @Override
    public Page<Order> findByCustomerId(Long customerId, Pageable pageable) {
        return orderRepository.findByCustomerId(customerId, pageable);
    }

    @Override
    public Page<Order> findByTotalAmountBetween(Float min, Float max, Pageable pageable) {
        return orderRepository.findByTotalAmountBetween(min, max, pageable);
    }
}
