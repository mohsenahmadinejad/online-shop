package com.ahmadi.onlineshop.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "t_customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    private String phone;
    private String address;


}
