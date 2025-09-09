package com.ahmadi.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tbl_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;


    @ManyToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Category> categories;

}
