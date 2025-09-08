package com.ahmadi.onlineshop.service;

import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDto  saveCustomer(CustomerDto customer);

    CustomerDto  getCustomerById(Long id);


    List<CustomerDto > getAllCustomers();
    void deleteCustomer(Long id);
}
