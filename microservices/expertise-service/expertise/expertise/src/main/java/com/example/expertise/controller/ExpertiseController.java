package com.example.expertise.controller;

import com.example.expertise.model.ExpertiseDTO;
import com.example.expertise.service.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expertises")
public class ExpertiseController {

    private final ExpertiseService expertiseService;

    @Autowired
    public ExpertiseController(ExpertiseService expertiseService) {
        this.expertiseService = expertiseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpertiseDTO> getExpertiseById(@PathVariable("id") Long id) {
        ExpertiseDTO expertiseDTO = expertiseService.getExpertiseById(id);
        return ResponseEntity.ok(expertiseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ExpertiseDTO>> getAllExpertise() {
        List<ExpertiseDTO> expertiseList = expertiseService.getAllExpertise();
        return ResponseEntity.ok(expertiseList);
    }

    @PostMapping
    public ResponseEntity<ExpertiseDTO> createExpertise(@RequestBody ExpertiseDTO expertiseDTO) {
        ExpertiseDTO createdExpertise = expertiseService.createExpertise(expertiseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpertise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpertiseDTO> updateExpertise(@PathVariable("id") Long id, @RequestBody ExpertiseDTO expertiseDTO) {
        ExpertiseDTO updatedExpertise = expertiseService.updateExpertise(id, expertiseDTO);
        return ResponseEntity.ok(updatedExpertise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpertise(@PathVariable("id") Long id) {
        expertiseService.deleteExpertise(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ExpertiseDTO>> getExpertiseByCategory(@PathVariable("categoryId") Long categoryId) {
        List<ExpertiseDTO> expertiseList = expertiseService.getExpertiseByCategory(categoryId);
        return ResponseEntity.ok(expertiseList);
    }
}

