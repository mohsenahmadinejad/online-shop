package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Long> {
}
