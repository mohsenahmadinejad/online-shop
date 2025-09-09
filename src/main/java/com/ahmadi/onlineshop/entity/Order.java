package com.ahmadi.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="t_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;


    @ManyToOne
    @JoinColumn(name = "fk_customer_id",referencedColumnName = "id",nullable = false)
    private Customer   customer;

    @OneToMany(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;




}
