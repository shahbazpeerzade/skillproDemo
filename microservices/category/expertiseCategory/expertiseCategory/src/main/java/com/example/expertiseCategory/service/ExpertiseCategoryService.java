package com.example.expertiseCategory.service;


import com.example.expertiseCategory.model.ExpertiseCategory;
import com.example.expertiseCategory.model.ExpertiseCategoryDTO;
import com.example.expertiseCategory.repository.ExpertiseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpertiseCategoryService {

    @Autowired
    private ExpertiseCategoryRepository expertiseCategoryRepository;

    // Convert Entity to DTO
    private ExpertiseCategoryDTO convertToDTO(ExpertiseCategory category) {
        ExpertiseCategoryDTO dto = new ExpertiseCategoryDTO();
//        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    // Get all categories
    public List<ExpertiseCategoryDTO> getAllExpertiseCategories() {
        List<ExpertiseCategory> categories = expertiseCategoryRepository.findAll();
        return categories.stream()
                         .map(this::convertToDTO)
                         .collect(Collectors.toList());
    }

    // Get category by ID
    public ExpertiseCategoryDTO getExpertiseCategoryById(Long id) {
        ExpertiseCategory category = expertiseCategoryRepository.findById(id).orElse(null);
        return convertToDTO(category);
    }


    // Create new category
    public ExpertiseCategoryDTO createExpertiseCategory(ExpertiseCategoryDTO dto) {
        ExpertiseCategory category = new ExpertiseCategory();
        category.setName(dto.getName());  // Set name from DTO to entity
        category.setDescription(dto.getDescription());  // Set name from DTO to entity
        ExpertiseCategory savedCategory = expertiseCategoryRepository.save(category);

        // Convert saved entity to DTO and return
        return convertToDTO(savedCategory);
    }

    // Update category
    public ExpertiseCategoryDTO updateExpertiseCategory(Long id, ExpertiseCategoryDTO dto) {
        ExpertiseCategory category = expertiseCategoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(dto.getName());
            category.setDescription(dto.getDescription());
            ExpertiseCategory updatedCategory = expertiseCategoryRepository.save(category);
            return convertToDTO(updatedCategory);
        }
        return null;
    }

    // Delete category
    public void deleteExpertiseCategory(Long id) {
        expertiseCategoryRepository.deleteById(id);
    }
}
