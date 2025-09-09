package com.ahmadi.onlineshop.service.impl;

import com.ahmadi.onlineshop.dto.OrderDto;
import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.entity.OrderItem;
import com.ahmadi.onlineshop.entity.Product;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.repository.OrderRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

    @Override
    public Order createOrder(Order order) {
        Customer customer=customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer Not found"));


        order.getOrderItems().forEach(orderItem -> {
            Product product=productRepository.findById(orderItem.getProduct().getId()).
                    orElseThrow(() -> new RuntimeException("Product not found"));
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
}
