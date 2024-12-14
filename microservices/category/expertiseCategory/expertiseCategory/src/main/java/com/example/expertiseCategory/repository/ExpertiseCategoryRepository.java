    package com.example.expertiseCategory.repository;

    import com.example.expertiseCategory.model.ExpertiseCategory;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface ExpertiseCategoryRepository extends JpaRepository<ExpertiseCategory, Long> {
}