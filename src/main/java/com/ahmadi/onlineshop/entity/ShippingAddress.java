package com.ahmadi.onlineshop.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_Shipping_Address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;
    private String address;

    @OneToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "id")
    private  Order order;


}
