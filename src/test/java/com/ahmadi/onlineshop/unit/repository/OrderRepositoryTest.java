package com.ahmadi.onlineshop.unit.repository;

import com.ahmadi.onlineshop.entity.*;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.repository.OrderRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")

class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    private Customer customer;
    private Product product;
    private Order order;

    @BeforeEach
    void setup() {
        customer = new Customer();
        customer.setFirstName("Ali");
        customer.setLastName("Ahmadi");
        customer = customerRepository.save(customer);

        product = new Product();
        product.setName("laptob");
        product.setPrice(100D);

        product = productRepository.save(product);

        order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(200D);

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(2);
        item.setPrice(200D);
        item.setOrder(order);

        order.setOrderItems(List.of(item));

        order = orderRepository.save(order);
    }

    @Test
    void testFindByOrderDateBetween() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now().plusDays(1);

        Page<Order> page = orderRepository.findByOrderDateBetween(start, end, PageRequest.of(0, 10));
        assertEquals(1, page.getContent().size());
        assertEquals(order.getId(), page.getContent().get(0).getId());
    }

    @Test
    void testFindByCustomerId() {
        Page<Order> page = orderRepository.findByCustomerId(customer.getId(), PageRequest.of(0, 10));
        assertEquals(1, page.getContent().size());
        assertEquals(customer.getId(), page.getContent().get(0).getCustomer().getId());
    }

    @Test
    void testFindByTotalAmountBetween() {
        Page<Order> page = orderRepository.findByTotalAmountBetween(100D, 300D, PageRequest.of(0, 10));
        assertEquals(1, page.getContent().size());
        assertEquals(order.getTotalAmount(), page.getContent().get(0).getTotalAmount());
    }
}