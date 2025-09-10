package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerDto  saveCustomer(CustomerDto customer);

    CustomerDto  getCustomerById(Long id);


    List<CustomerDto > getAllCustomers();
    void deleteCustomer(Long id);




    public Page<Customer> searchByName(String firstName, String lastName, Pageable pageable);
    public Page<Customer> searchByPhone(String phone, Pageable pageable);


    }
