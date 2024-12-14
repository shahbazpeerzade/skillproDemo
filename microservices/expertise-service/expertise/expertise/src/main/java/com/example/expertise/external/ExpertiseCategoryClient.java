package com.example.expertise.external;

import com.example.expertiseCategory.model.ExpertiseCategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service")
public interface ExpertiseCategoryClient {

    @GetMapping("/api/categories/{id}")
    ExpertiseCategoryDTO getCategoryById(@PathVariable("id") Long id);
}

