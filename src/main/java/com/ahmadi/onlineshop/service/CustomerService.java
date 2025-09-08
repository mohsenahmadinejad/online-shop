package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

      Optional<Customer> getCustomerById(Long id);


    List<Customer> getAllCustomers();
    void deleteCustomer(Long id);
}
