package com.ahmadi.onlineshop.unit.service;

import com.ahmadi.onlineshop.entity.*;
import com.ahmadi.onlineshop.exception.CustomerNotFoundException;
import com.ahmadi.onlineshop.exception.ProductNotFoundException;
import com.ahmadi.onlineshop.exception.StockNotFoundException;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.repository.OrderRepository;
import com.ahmadi.onlineshop.repository.ProductRepository;
import com.ahmadi.onlineshop.repository.StockRepository;
import com.ahmadi.onlineshop.service.StockService;
import com.ahmadi.onlineshop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.OptimisticLockingFailureException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.exception.CustomerNotFoundException;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testSaveCustomer() {
        CustomerDto dto = new CustomerDto();
        dto.setFirstName("Ali");

        Customer customer = new Customer();
        customer.setFirstName("Ali");

        Customer savedCustomer = new Customer();
        savedCustomer.setId(1L);
        savedCustomer.setFirstName("Ali");

        Mockito.when(modelMapper.map(dto, Customer.class)).thenReturn(customer);
        Mockito.when(customerRepository.save(customer)).thenReturn(savedCustomer);
        Mockito.when(modelMapper.map(savedCustomer, CustomerDto.class)).thenReturn(dto);

        CustomerDto result = customerService.saveCustomer(dto);

        assertNotNull(result);
        assertEquals("Ali", result.getFirstName());
        Mockito.verify(customerRepository).save(customer);
    }

    @Test
    void testGetCustomerById_Found() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ali");

        CustomerDto dto = new CustomerDto();
        dto.setId(1L);
        dto.setFirstName("Ali");

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(modelMapper.map(customer, CustomerDto.class)).thenReturn(dto);

        CustomerDto result = customerService.getCustomerById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Ali", result.getFirstName());
    }

    @Test
    void testGetCustomerById_NotFound() {
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        CustomerDto result = customerService.getCustomerById(1L);

        assertNull(result);
    }

    @Test
    void testUpdateCustomer_Success() {
        Customer existing = new Customer();
        existing.setId(1L);
        existing.setFirstName("Old");

        CustomerDto dto = new CustomerDto();
        dto.setFirstName("Mohsen");
        dto.setLastName("Ahmadi");
        dto.setAddress("Tehran");
        dto.setPhone("123");

        Customer updated = new Customer();
        updated.setId(1L);
        updated.setFirstName("Ali");

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(existing));
        Mockito.when(customerRepository.save(existing)).thenReturn(updated);

        Customer result = customerService.updateCustomer(1L, dto);

        assertNotNull(result);
        assertEquals("Ali", result.getFirstName());
        Mockito.verify(customerRepository).save(existing);
    }

    @Test
    void testUpdateCustomer_NotFound() {
        CustomerDto dto = new CustomerDto();
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () ->
                customerService.updateCustomer(1L, dto));
    }

    @Test
    void testDeleteCustomer() {
        customerService.deleteCustomer(1L);
        Mockito.verify(customerRepository).deleteById(1L);
    }

    @Test
    void testGetAllCustomers() {
        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setFirstName("Ali");

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setFirstName("Reza");

        List<Customer> customers = List.of(c1, c2);

        CustomerDto dto1 = new CustomerDto();
        dto1.setId(1L);
        dto1.setFirstName("Ali");

        CustomerDto dto2 = new CustomerDto();
        dto2.setId(2L);
        dto2.setFirstName("Reza");

        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        Mockito.when(modelMapper.map(c1, CustomerDto.class)).thenReturn(dto1);
        Mockito.when(modelMapper.map(c2, CustomerDto.class)).thenReturn(dto2);

        List<CustomerDto> result = customerService.getAllCustomers();

        assertEquals(2, result.size());
        assertEquals("Ali", result.get(0).getFirstName());
        assertEquals("Reza", result.get(1).getFirstName());
    }

    @Test
    void testSearchByName() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ali");
        customer.setLastName("Reza");

        Page<Customer> page = new PageImpl<>(List.of(customer));

        Mockito.when(customerRepository
                        .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
                                "Ali", "Reza", PageRequest.of(0, 10)))
                .thenReturn(page);

        Page<Customer> result = customerService.searchByName("Ali", "Reza", PageRequest.of(0, 10));

        assertEquals(1, result.getContent().size());
        assertEquals("Ali", result.getContent().get(0).getFirstName());
    }

    @Test
    void testSearchByPhone() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setPhone("123");

        Page<Customer> page = new PageImpl<>(List.of(customer));

        Mockito.when(customerRepository.findByPhoneContaining("123", PageRequest.of(0, 10)))
                .thenReturn(page);

        Page<Customer> result = customerService.searchByPhone("123", PageRequest.of(0, 10));

        assertEquals(1, result.getContent().size());
        assertEquals("123", result.getContent().get(0).getPhone());
    }
}