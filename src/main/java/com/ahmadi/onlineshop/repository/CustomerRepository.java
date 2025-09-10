package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.dto.CustomerDto;
import com.ahmadi.onlineshop.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor {

    Page<Customer> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable
    );


    Page<Customer> findByPhoneContaining(String phone, Pageable pageable);


}
