package com.ahmadi.onlineshop.service.impl;

import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    private  CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}