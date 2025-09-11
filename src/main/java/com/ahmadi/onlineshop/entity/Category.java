package com.ahmadi.onlineshop.entity;


import com.ahmadi.onlineshop.config.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the category", example = "201")
    private Long id;

    @Schema(description = "Name of the category", example = "Electronics")
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    @Schema(description = "Description of the category", example = "All electronic devices and gadgets")
    private List<Product> products = new ArrayList<>();


}
