package com.Category.Category_service.service;


import com.Category.Category_service.module.Category;
import com.Category.Category_service.module.CategoryDTO;
import com.Category.Category_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        // Map DTO to Entity
        Category category = new Category();
        category.setName(categoryDTO.getName());

        // Save entity in the database
        Category savedCategory = categoryRepository.save(category);

        // Map saved entity to DTO
        return mapToDTO(savedCategory);
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            return mapToDTO(categoryOptional.get());
        } else {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Utility method to map entity to DTO
    private CategoryDTO mapToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
