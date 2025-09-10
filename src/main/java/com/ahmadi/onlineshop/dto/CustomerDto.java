package com.ahmadi.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    @Schema(description = "Unique identifier of the customer", example = "1")
    private Long id;
    @Schema(description = "First name of the customer", example = "Ali")
    private String firstName;
    @Schema(description = "Lastname name of the customer", example = "Ahmadi")
    private String lastName;
    @Schema(description = "Phone number name of the customer", example = "09125040111")
    private String phone;
    @Schema(description = "Address  of the customer", example = "Enghelab St")
    private String address;


}