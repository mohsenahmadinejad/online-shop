package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/search/by-date-between") //2025-01-14T07:09:31
    public Page<Order> searchOrders(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @PageableDefault(size = 10, sort = "orderDate", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return orderService.findByOrderDateBetween(start, end, pageable);
    }

    @GetMapping("/search/by-customer")
    public Page<Order> getOrdersByCustomer(
            @RequestParam("customerId") Long customerId,
            @PageableDefault(size = 10, sort = "orderDate", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return orderService.findByCustomerId(customerId, pageable);
    }

    @GetMapping("/search/by-amount")
    public Page<Order> searchOrdersByAmount(
            @RequestParam("min") Float min,
            @RequestParam("max") Float max,
            @PageableDefault(size = 10, sort = "orderDate", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return orderService.findByTotalAmountBetween(min, max, pageable);
    }


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
