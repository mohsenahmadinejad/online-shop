package com.ahmadi.onlineshop.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "t_category_product",
    joinColumns = @JoinColumn(name = "fk_product_id",referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(name = "fk_category_id",referencedColumnName = "id"))
    @JsonBackReference
    private List<Product> product;


}
