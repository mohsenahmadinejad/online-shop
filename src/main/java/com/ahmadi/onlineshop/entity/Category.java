package com.ahmadi.onlineshop.entity;


import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the category", example = "201")
    private Long id;

    @Schema(description = "Name of the category", example = "Electronics")
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<Product> products = new ArrayList<>();


}
