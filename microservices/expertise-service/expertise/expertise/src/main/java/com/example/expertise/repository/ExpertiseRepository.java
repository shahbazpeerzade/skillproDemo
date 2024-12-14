package com.example.expertise.repository;


import com.example.expertise.model.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {
    List<Expertise> findByCategoryId(Long categoryId);
}

