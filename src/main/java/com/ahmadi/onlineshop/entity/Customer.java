package com.ahmadi.onlineshop.entity;


import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "t_customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "orders")
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    private String phone;
    private String address;

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_customer_id" ,referencedColumnName = "id" ,nullable = false )
//    @JsonIgnore
    @JsonBackReference
    @Schema(description = "List of orders placed by the customer")
    private List<Order> orders;

}
