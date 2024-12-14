package com.product.service.external;


import com.productCategory.service.module.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service",url = "http://localhost:8083/api/categories")
public interface CategoryClient {

    @GetMapping("/{id}")
    CategoryDto getCategoryById(@PathVariable Long id);
}

