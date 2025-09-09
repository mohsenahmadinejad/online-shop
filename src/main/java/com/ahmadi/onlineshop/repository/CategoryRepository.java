package com.ahmadi.onlineshop.repository;

import com.ahmadi.onlineshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
