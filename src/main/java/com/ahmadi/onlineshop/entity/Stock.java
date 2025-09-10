package com.ahmadi.onlineshop.entity;


import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_stock")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Stock  extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the stock record", example = "701")
    private Long id;

    @Schema(description = "Available quantity in stock", example = "15")
    private int quantity;

    @OneToOne
    @JoinColumn(name="fk_product_id",referencedColumnName = "id")
    @JsonBackReference
    private Product product;


    @Version
    @JsonIgnore
    @Schema(description = "Hibernate version for optimistic locking", example = "15")
    private Long version;
}
