package com.ahmadi.onlineshop.controller.v1;

import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Tag(name = "Customer", description = "Operations related to customers")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private  CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/search-by-name") //GET /api/customers/search-by-name?firstName=ali&lastName=ahmadi&page=1&size=5&sortBy=lastName&direction=desc
    @Operation(summary = "Search customers with pagination and sorting", description = "Search customers with filters phone number")
    public Page<Customer> searchByName(
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "") String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "lastName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return customerService.searchByName(firstName,lastName, pageable);
    }


    @GetMapping("/phone") //GET /api/customers/phone?phone=0912&sortBy=firstName&direction=asc
    @Operation(summary = "Search customers with pagination and sorting", description = "Search customers with filters phone number")
    public Page<Customer> searchByPhone(
            @RequestParam String phone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return customerService.searchByPhone(phone, pageable);
    }





    @PostMapping
    @Operation(summary = "Create a new customer", description = "Register a new customer in the system")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto saved = customerService.saveCustomer(customerDto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID", description = "Fetch a single customer by its ID")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto dto = customerService.getCustomerById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Get all customers", description = "Fetch all customers ")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer", description = "Remove a customer by ID")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update a customer", description = "Update customer details by ID")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto ) {
        return customerService.updateCustomer(id, customerDto);
    }
}