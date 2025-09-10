package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
