package com.example.expertise.service;

import com.example.expertise.model.ExpertiseDTO;

import java.util.List;

public interface ExpertiseService {
    ExpertiseDTO getExpertiseById(Long id);
    List<ExpertiseDTO> getAllExpertise();
    ExpertiseDTO createExpertise(ExpertiseDTO expertiseDTO);
    ExpertiseDTO updateExpertise(Long id, ExpertiseDTO expertiseDTO);
    void deleteExpertise(Long id);
    List<ExpertiseDTO> getExpertiseByCategory(Long categoryId);
}