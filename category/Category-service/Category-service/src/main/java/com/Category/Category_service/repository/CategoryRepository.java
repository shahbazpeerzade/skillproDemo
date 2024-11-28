package com.Category.Category_service.repository;


import com.Category.Category_service.module.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional custom queries can be added here if needed
}
