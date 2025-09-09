package com.ahmadi.onlineshop.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;

}
