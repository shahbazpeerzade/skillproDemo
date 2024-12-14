package com.example.expertise.service.impl;

import com.example.expertise.external.ExpertiseCategoryClient;
import com.example.expertise.model.Expertise;
import com.example.expertise.model.ExpertiseDTO;
import com.example.expertise.repository.ExpertiseRepository;
import com.example.expertise.service.ExpertiseService;
import com.example.expertiseCategory.model.ExpertiseCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {

    private final ExpertiseRepository expertiseRepository;
    private final ExpertiseCategoryClient expertiseCategoryClient;

    @Autowired
    public ExpertiseServiceImpl(ExpertiseRepository expertiseRepository,
                                ExpertiseCategoryClient expertiseCategoryClient) {
        this.expertiseRepository = expertiseRepository;
        this.expertiseCategoryClient = expertiseCategoryClient;
    }

    @Override
    public ExpertiseDTO getExpertiseById(Long id) {
        Expertise expertise = expertiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expertise not found"));

        // Fetch category details using Feign Client
        ExpertiseCategoryDTO categoryDTO = expertiseCategoryClient.getCategoryById(expertise.getCategoryId());

        return convertToDTO(expertise, categoryDTO);
    }

    @Override
    public List<ExpertiseDTO> getAllExpertise() {
        List<Expertise> expertiseList = expertiseRepository.findAll();
        return expertiseList.stream()
                .map(expertise -> {
                    ExpertiseCategoryDTO categoryDTO = expertiseCategoryClient.getCategoryById(expertise.getCategoryId());
                    return convertToDTO(expertise, categoryDTO);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ExpertiseDTO createExpertise(ExpertiseDTO expertiseDTO) {
        Expertise expertise = new Expertise();
        expertise.setName(expertiseDTO.getName());
        expertise.setDescription(expertiseDTO.getDescription());
        expertise.setExperienceLevel(expertiseDTO.getExperienceLevel());
        expertise.setYearsOfExperience(expertiseDTO.getYearsOfExperience());
        expertise.setHourlyRate(expertiseDTO.getHourlyRate());
        expertise.setCategoryId(expertiseDTO.getCategoryId()); // Only set category ID

        Expertise savedExpertise = expertiseRepository.save(expertise);

        // Fetch category details using Feign Client
        ExpertiseCategoryDTO categoryDTO = expertiseCategoryClient.getCategoryById(savedExpertise.getCategoryId());

        return convertToDTO(savedExpertise, categoryDTO);
    }

    @Override
    public ExpertiseDTO updateExpertise(Long id, ExpertiseDTO expertiseDTO) {
        Expertise expertise = expertiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expertise not found"));

        expertise.setName(expertiseDTO.getName());
        expertise.setDescription(expertiseDTO.getDescription());
        expertise.setExperienceLevel(expertiseDTO.getExperienceLevel());
        expertise.setYearsOfExperience(expertiseDTO.getYearsOfExperience());
        expertise.setHourlyRate(expertiseDTO.getHourlyRate());
        expertise.setCategoryId(expertiseDTO.getCategoryId()); // Only update category ID

        Expertise updatedExpertise = expertiseRepository.save(expertise);

        // Fetch category details using Feign Client
        ExpertiseCategoryDTO categoryDTO = expertiseCategoryClient.getCategoryById(updatedExpertise.getCategoryId());

        return convertToDTO(updatedExpertise, categoryDTO);
    }

    @Override
    public void deleteExpertise(Long id) {
        expertiseRepository.deleteById(id);
    }

    @Override
    public List<ExpertiseDTO> getExpertiseByCategory(Long categoryId) {
        List<Expertise> expertiseList = expertiseRepository.findByCategoryId(categoryId);
        return expertiseList.stream()
                .map(expertise -> {
                    ExpertiseCategoryDTO categoryDTO = expertiseCategoryClient.getCategoryById(expertise.getCategoryId());
                    return convertToDTO(expertise, categoryDTO);
                })
                .collect(Collectors.toList());
    }

    private ExpertiseDTO convertToDTO(Expertise expertise, ExpertiseCategoryDTO categoryDTO) {
        ExpertiseDTO dto = new ExpertiseDTO();
        dto.setId(expertise.getId());
        dto.setName(expertise.getName());
        dto.setDescription(expertise.getDescription());
        dto.setExperienceLevel(expertise.getExperienceLevel());
        dto.setYearsOfExperience(expertise.getYearsOfExperience());
        dto.setHourlyRate(expertise.getHourlyRate());
        dto.setCategoryId(categoryDTO.getId());
        dto.setCategoryId(categoryDTO.getId());  // Set category name directly from DTO
        // Map other fields here
        return dto;
    }
}
