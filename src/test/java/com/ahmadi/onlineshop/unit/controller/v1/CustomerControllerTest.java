package com.ahmadi.onlineshop.unit.controller.v1;


import com.ahmadi.onlineshop.controller.v1.CustomerController;
import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {

    private MockMvc mockMvc;
    private CustomerService customerService;
    private CustomerController customerController;
    private ObjectMapper objectMapper;

    private CustomerDto customerDto;
    private Customer customer;

    @BeforeEach
    void setup() {
        customerService = Mockito.mock(CustomerService.class);
        customerController = new CustomerController(customerService);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        objectMapper = new ObjectMapper();

        customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setFirstName("Ali");
        customerDto.setLastName("Ahmadi");
        customerDto.setPhone("09121234567");

        customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ali");
        customer.setLastName("Ahmadi");
        customer.setPhone("09121234567");
    }

    @Test
    void testCreateCustomer() throws Exception {
        Mockito.when(customerService.saveCustomer(any(CustomerDto.class))).thenReturn(customerDto);

        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Ali"));
    }

    @Test
    void testGetCustomerById_Found() throws Exception {
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customerDto);

        mockMvc.perform(get("/api/v1/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Ali"));
    }

    @Test
    void testGetCustomerById_NotFound() throws Exception {
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(null);

        mockMvc.perform(get("/api/v1/customers/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetAllCustomers() throws Exception {
        Mockito.when(customerService.getAllCustomers()).thenReturn(List.of(customerDto));

        mockMvc.perform(get("/api/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Ali"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/v1/customers/1"))
                .andExpect(status().isNoContent());

        Mockito.verify(customerService).deleteCustomer(1L);
    }

    @Test
    void testUpdateCustomer() throws Exception {
        Mockito.when(customerService.updateCustomer(any(Long.class), any(CustomerDto.class)))
                .thenReturn(customer);

        mockMvc.perform(put("/api/v1/customers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Ali"));
    }


}