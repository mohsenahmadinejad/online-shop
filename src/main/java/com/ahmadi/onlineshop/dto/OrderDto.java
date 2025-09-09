package com.ahmadi.onlineshop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class OrderDto {
    private Long id;
    private CustomerDto customer;
    private LocalDateTime orderDate;
    private Double totalAmount;

    private List<OrderItemDto> items;


}
