package com.ahmadi.onlineshop.entity;


import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Unique identifier of the order item", example = "101")
    private Long id;

    @Schema(description = "Quantity of the product in the order", example = "2")
    private Integer quantity;

    @Schema(description = "Price of the product at the time of order", example = "125000.25")
    private Double price;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_product_id",referencedColumnName = "id")
    @Schema(description = "The product being ordered")
//    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    @JsonBackReference
    @Schema(description = "The order this item belongs to")
    private Order order;
}

