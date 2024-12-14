package com.example.expertiseCategory.model;

import lombok.Data;
@Data
public class ExpertiseCategoryDTO {
    private Long id;
    private String name;  // Represents the name of the category
    private String description;  // Represents the name of the category

    public ExpertiseCategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}