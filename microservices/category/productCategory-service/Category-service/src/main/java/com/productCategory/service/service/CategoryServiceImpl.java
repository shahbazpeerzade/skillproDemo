package com.productCategory.service.service;

import com.productCategory.service.module.Category;
import com.productCategory.service.module.CategoryDto;
import com.productCategory.service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired // This ensures that Spring injects the CategoryRepository bean
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDTO) {
        // Map DTO to Entity
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        // Save entity in the database
        Category savedCategory = categoryRepository.save(category);

        // Map saved entity to DTO
        return mapToDTO(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            return mapToDTO(categoryOptional.get());
        } else {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryDtos.add(mapToDTO(category));
        }
        return categoryDtos;
    }

    // Utility method to map entity to DTO
    private CategoryDto mapToDTO(Category category) {
        CategoryDto categoryDTO = new CategoryDto();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}