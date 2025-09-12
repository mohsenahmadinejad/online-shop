package com.ahmadi.onlineshop.unit.controller.v1;

import com.ahmadi.onlineshop.controller.v1.OrderController;
import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.entity.OrderItem;
import com.ahmadi.onlineshop.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    private MockMvc mockMvc;
    private OrderService orderService;
    private OrderController orderController;
    private ObjectMapper objectMapper;

    private Order order;

    @BeforeEach
    void setup() {
        orderService = Mockito.mock(OrderService.class);
        orderController = new OrderController(orderService);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        objectMapper = new ObjectMapper();

        // نمونه Order
        order = new Order();
        order.setId(1L);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(100.0);
        order.setOrderItems(List.of(new OrderItem()));
    }


    @Test
    void testGetOrderById_Found() throws Exception {
        Mockito.when(orderService.getById(1L)).thenReturn(order);

        mockMvc.perform(get("/api/v1/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testGetOrderById_NotFound() throws Exception {
        Mockito.when(orderService.getById(1L)).thenReturn(null);

        mockMvc.perform(get("/api/v1/orders/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testListOrders() throws Exception {
        Mockito.when(orderService.getAll()).thenReturn(List.of(order));

        mockMvc.perform(get("/api/v1/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }



}