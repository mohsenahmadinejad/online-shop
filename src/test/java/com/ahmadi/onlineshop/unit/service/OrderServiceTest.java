package com.ahmadi.onlineshop.unit.service;

import com.ahmadi.onlineshop.entity.*;
import com.ahmadi.onlineshop.exception.CustomerNotFoundException;
import com.ahmadi.onlineshop.exception.ProductNotFoundException;
import com.ahmadi.onlineshop.exception.StockNotFoundException;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.repository.OrderRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.repository.StockRepository;
import com.ahmadi.onlineshop.service.StockService;
import com.ahmadi.onlineshop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private StockService stockService;


    @InjectMocks
    private OrderServiceImpl orderService;




    @Test
    void testCreateOrder_Success() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ali");

        Product product = new Product();
        product.setId(10L);
        product.setPrice(100.0);

        Stock stock = new Stock();
        stock.setId(20L);
        stock.setProduct(product);
        stock.setQuantity(50);

        OrderItem orderItem = new OrderItem();
        orderItem.setId(100L);
        orderItem.setProduct(product);
        orderItem.setQuantity(2);

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(List.of(orderItem));

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        Mockito.when(stockRepository.findByProductId(10L)).thenReturn(Optional.of(stock));
        Mockito.when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));


        Mockito.doNothing().when(stockService).reduceStock(100L, 2);


        Order savedOrder = orderService.createOrder(order);


        assertNotNull(savedOrder);
        assertEquals(customer, savedOrder.getCustomer());
        assertEquals(200.0, savedOrder.getTotalAmount());
        assertEquals(savedOrder, orderItem.getOrder());

        Mockito.verify(orderRepository).save(order);
        Mockito.verify(stockService).reduceStock(100L, 2);
    }

    @Test
    void testCreateOrder_CustomerNotFound() {
        Customer customer = new Customer();
        customer.setId(1L);

        Order order = new Order();
        order.setCustomer(customer);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () ->
                orderService.createOrder(order));
    }

    @Test
    void testCreateOrder_ProductNotFound() {
        Customer customer = new Customer();
        customer.setId(1L);

        Product product = new Product();
        product.setId(10L);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(2);

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(List.of(orderItem));

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(productRepository.findById(10L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () ->
                orderService.createOrder(order));
    }

    @Test
    void testCreateOrder_StockNotFound() {
        Customer customer = new Customer();
        customer.setId(1L);

        Product product = new Product();
        product.setId(10L);
        product.setPrice(100.0);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(2);

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(List.of(orderItem));

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        Mockito.when(stockRepository.findByProductId(10L)).thenReturn(Optional.empty());

        assertThrows(StockNotFoundException.class, () ->
                orderService.createOrder(order));
    }

    @Test
    void testCreateOrder_RetryOnOptimisticLockingFailure() {
        Customer customer = new Customer();
        customer.setId(1L);

        Product product = new Product();
        product.setId(10L);
        product.setPrice(100.0);

        Stock stock = new Stock();
        stock.setId(20L);
        stock.setProduct(product);
        stock.setQuantity(50);

        OrderItem orderItem = new OrderItem();
        orderItem.setId(100L);
        orderItem.setProduct(product);
        orderItem.setQuantity(1);

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(List.of(orderItem));

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        Mockito.when(stockRepository.findByProductId(10L)).thenReturn(Optional.of(stock));

        Mockito.when(orderRepository.save(any(Order.class)))
                .thenThrow(new OptimisticLockingFailureException("conflict"))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Mockito.doNothing().when(stockService).reduceStock(100L, 1);

        Order savedOrder = orderService.createOrder(order);

        assertNotNull(savedOrder);
        assertEquals(customer, savedOrder.getCustomer());
        Mockito.verify(orderRepository, Mockito.times(2)).save(order);
    }

    @Test
    void testGetById_Found() {
        Order order = new Order();
        order.setId(1L);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order result = orderService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testGetById_NotFound() {
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.empty());

        Order result = orderService.getById(1L);

        assertNull(result);
    }

    @Test
    void testGetAll() {
        Order order1 = new Order();
        order1.setId(1L);
        Order order2 = new Order();
        order2.setId(2L);

        List<Order> orders = List.of(order1, order2);

        Mockito.when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAll();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    void testFindByOrderDateBetween() {
        Order order = new Order();
        order.setId(1L);
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();

        Page<Order> page = new PageImpl<>(List.of(order));

        Mockito.when(orderRepository.findByOrderDateBetween(start, end, PageRequest.of(0, 10)))
                .thenReturn(page);

        Page<Order> result = orderService.findByOrderDateBetween(start, end, PageRequest.of(0, 10));

        assertEquals(1, result.getContent().size());
        assertEquals(1L, result.getContent().get(0).getId());
    }

    @Test
    void testFindByCustomerId() {
        Customer customer = new Customer();
        customer.setId(1L);

        Order order = new Order();
        order.setId(100L);
        order.setCustomer(customer);

        Page<Order> page = new PageImpl<>(List.of(order));

        Mockito.when(orderRepository.findByCustomerId(1L, PageRequest.of(0, 10)))
                .thenReturn(page);

        Page<Order> result = orderService.findByCustomerId(1L, PageRequest.of(0, 10));

        assertEquals(1, result.getContent().size());
        assertEquals(100L, result.getContent().get(0).getId());
    }

    @Test
    void testFindByTotalAmountBetween() {
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(200D);

        Page<Order> page = new PageImpl<>(List.of(order));

        Mockito.when(orderRepository.findByTotalAmountBetween(100D, 300D, PageRequest.of(0, 10)))
                .thenReturn(page);

        Page<Order> result = orderService.findByTotalAmountBetween(100D, 300D, PageRequest.of(0, 10));

        assertEquals(1, result.getContent().size());
        assertEquals(200f, result.getContent().get(0).getTotalAmount());
    }
}
