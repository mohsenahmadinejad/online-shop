package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id) {
        Order order=orderService.getById(id);
        return  order!=null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();

    }

    public ResponseEntity<List<Order>> list() {
        return ResponseEntity.ok(orderService.getAll());
    }


    }
