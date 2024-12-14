package com.productCategory.service.repository;


import com.productCategory.service.module.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional custom queries can be added here if needed
}
