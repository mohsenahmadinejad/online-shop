package com.ahmadi.onlineshop.entity;

import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="t_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the order", example = "101")
    private Long id;

    @Schema(description = "Date and time when the order was placed", example = "2025-01-14T12:30:00")
    private LocalDateTime orderDate;

    @Schema(description = "Total amount of the order", example = "250000")
    private Double totalAmount;


    @ManyToOne
    @JoinColumn(name = "fk_customer_id",referencedColumnName = "id",nullable = false)
    @JsonBackReference
    @Schema(description = "Customer who placed the order")
    private Customer   customer;

    @OneToMany(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    @Schema(description = "List of items in the order")
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    @Schema(description = "The Address for shipping the order")
    private ShippingAddress shippingAddress;




}
