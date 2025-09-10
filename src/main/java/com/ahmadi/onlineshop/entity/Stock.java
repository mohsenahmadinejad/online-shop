package com.ahmadi.onlineshop.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_stock")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int quantity;

    @OneToOne
    @JoinColumn(name="fk_product_id",referencedColumnName = "id")
    @JsonBackReference
    private Product product;


    @Version
    @JsonIgnore
    private Long version;
}
