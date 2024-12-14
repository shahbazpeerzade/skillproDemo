package com.example.expertiseCategory.controller;


import com.example.expertiseCategory.model.ExpertiseCategory;
import com.example.expertiseCategory.model.ExpertiseCategoryDTO;
import com.example.expertiseCategory.service.ExpertiseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/expertise-categories")
public class ExpertiseCategoryController {

    @Autowired
    private ExpertiseCategoryService expertiseCategoryService;

    @GetMapping
    public List<ExpertiseCategoryDTO> getAllExpertiseCategories() {
        return expertiseCategoryService.getAllExpertiseCategories();
    }

    @GetMapping("/{id}")
    public ExpertiseCategoryDTO getExpertiseCategoryById(@PathVariable Long id) {
        return expertiseCategoryService.getExpertiseCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<ExpertiseCategory> createCategory(@Valid @RequestBody ExpertiseCategory category) {
        // Logic to save category
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{id}")
    public ExpertiseCategoryDTO updateExpertiseCategory(@PathVariable Long id, @RequestBody ExpertiseCategoryDTO expertiseCategoryDTO) {
        return expertiseCategoryService.updateExpertiseCategory(id, expertiseCategoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteExpertiseCategory(@PathVariable Long id) {
        expertiseCategoryService.deleteExpertiseCategory(id);
    }
}
