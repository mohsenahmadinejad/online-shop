package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Order", description = "Operations related to orders")
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @Operation(
            summary = "Search orders by date range",
            description = "Find orders placed between startDate and endDate"
    )@GetMapping("/search/by-date-between") //2025-01-14T07:09:31
    public Page<Order> searchOrders(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @PageableDefault(size = 10, sort = "orderDate", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return orderService.findByOrderDateBetween(start, end, pageable);
    }

    @Operation(
            summary = "Search orders by customer ID",
            description = "Find all orders placed by a specific customer"
    )@GetMapping("/search/by-customer")
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


    @Operation(summary = "Create a new order", description = "Place a new order for a customer")
    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @Operation(summary = "Get order by ID", description = "Fetch a single order by its unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id) {
        Order order=orderService.getById(id);
        return  order!=null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();

    }

    @GetMapping
    @Operation(summary = "Get all orders", description = "Fetch all orders ")
    public ResponseEntity<List<Order>> list() {
        return ResponseEntity.ok(orderService.getAll());
    }


    }
