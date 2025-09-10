package com.ahmadi.onlineshop.service.impl;

import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import com.ahmadi.onlineshop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {

    private  CustomerRepository customerRepository;
    private  ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer saved = customerRepository.save(customer);

        return modelMapper.map(saved, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .orElse(null);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer->modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> searchByName(String firstName, String lastName, Pageable pageable) {
        return customerRepository
                .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName, pageable);
    }

    @Override
    public Page<Customer> searchByPhone(String phone, Pageable pageable) {
        return customerRepository.findByPhoneContaining(phone, pageable);
    }

}