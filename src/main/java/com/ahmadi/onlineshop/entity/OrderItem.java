package com.ahmadi.onlineshop.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "t_order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer quantity;
    private Double price;




    @ManyToOne
    @JoinColumn(name = "fk_product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    private Order order;
}

