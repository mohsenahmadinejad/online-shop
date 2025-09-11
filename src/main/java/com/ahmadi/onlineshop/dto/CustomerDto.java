package com.ahmadi.onlineshop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private Long id;

    @Schema(description = "First name of the customer", example = "Ali")
    @NotBlank(message = "firstName can not be blank")
    private String firstName;

    @NotBlank
    @Schema(description = "Lastname name of the customer", example = "Ahmadi")
    @NotBlank(message = "lastName can not be blank")
    private String lastName;

    @Schema(description = "Phone number name of the customer", example = "09125040111")
    private String phone;

    @Schema(description = "Address  of the customer", example = "Enghelab St")
    private String address;


}