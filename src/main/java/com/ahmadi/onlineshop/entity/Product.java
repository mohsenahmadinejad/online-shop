package com.ahmadi.onlineshop.entity;

import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tbl_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Product extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the product", example = "301")
    private Long id;

    @Schema(description = "Name of the product", example = "Lenovo Laptop ThinkPad X1")
    private String name;

    @Schema(description = "Price of the product", example = "48000000")
    private Double price;


    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Schema(description = "Categories that this product belongs to")
    private List<Category> categories = new ArrayList<>();

    @OneToOne(mappedBy = "product" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    @Schema(description = "Stock information of the product")
    private Stock stock ;


}
