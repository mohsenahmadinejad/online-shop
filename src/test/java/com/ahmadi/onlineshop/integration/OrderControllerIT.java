package com.ahmadi.onlineshop.integration;

import com.ahmadi.onlineshop.entity.*;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.repository.OrderRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.repository.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OrderControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer customer;
    private Product product;
    private Stock stock;

    @BeforeEach
    void setup() {
        orderRepository.deleteAll();
        stockRepository.deleteAll();
        productRepository.deleteAll();
        customerRepository.deleteAll();

        customer = new Customer();
        customer.setFirstName("Ali");
        customer.setLastName("Ahmadi");
        customer = customerRepository.save(customer);

        product = new Product();
        product.setPrice(50D);
        product.setName("laptop");
        product = productRepository.save(product);

    }




    @Test
    void testFindByTotalAmountBetween() throws Exception {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(3);
        orderItem.setPrice(product.getPrice()*orderItem.getQuantity());

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(List.of(orderItem));
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(150D);

        orderRepository.save(order);

        mockMvc.perform(get("/api/v1/orders/search/by-amount")
                        .param("min", "50")
                        .param("max", "200")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].totalAmount", is(150.0)));
    }


}