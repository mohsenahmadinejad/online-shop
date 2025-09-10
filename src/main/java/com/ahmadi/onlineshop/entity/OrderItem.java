package com.ahmadi.onlineshop.entity;


import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "t_order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer quantity;
    private Double price;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_product_id",referencedColumnName = "id")
//    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    @JsonBackReference
    private Order order;
}

