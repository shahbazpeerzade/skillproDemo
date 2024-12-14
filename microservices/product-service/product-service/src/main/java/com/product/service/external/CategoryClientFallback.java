package com.product.service.external;

import com.productCategory.service.module.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CategoryClientFallback implements CategoryClient {

    private static final Logger logger = LoggerFactory.getLogger(CategoryClientFallback.class);
//
//    @Override
//    public CategoryDto getCategoryById(Long id) {
//        // Log the failure
//        logger.error("Failed to retrieve category with id: {}. Returning fallback response.", id);
//
//        // Return a fallback category
//        CategoryDto fallbackCategory = new CategoryDto();
//        fallbackCategory.setId(id);
//        fallbackCategory.setName("Unknown Category");
//        return fallbackCategory;
//    }
    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        // Return null to signify that the category does not exist
        return null;
    }
}
