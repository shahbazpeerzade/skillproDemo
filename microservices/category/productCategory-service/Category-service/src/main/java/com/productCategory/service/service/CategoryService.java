package com.productCategory.service.service;


import com.productCategory.service.module.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDTO);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategories();
}
