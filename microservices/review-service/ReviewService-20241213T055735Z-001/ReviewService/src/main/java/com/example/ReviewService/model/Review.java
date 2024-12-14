package com.example.ReviewService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewerName;
    private int rating;  
    private String comment;
    private Long skillExpert_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getskillExpert_id() {
		return skillExpert_id;
	}
	public void setskillExpert_id(Long skillExpert_id) {
		this.skillExpert_id = skillExpert_id;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewerName=" + reviewerName + ", rating=" + rating + ", comment=" + comment
				+ ", skillExpert_id=" + skillExpert_id + "]";
	}
	public Review(Long id, String reviewerName, int rating, String comment, Long skillExpert_id) {
		super();
		 if (rating < 1 || rating > 5) {
	            throw new IllegalArgumentException("Rating must be between 1 and 5.");
	        }
		this.id = id;
		this.reviewerName = reviewerName;
		this.rating = rating;
		this.comment = comment;
		this.skillExpert_id = skillExpert_id;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}  
    
    
	public Review(ReviewDTO reviewDTO) {
		super();
		 
		this.id = reviewDTO.getId();
		this.reviewerName = reviewDTO.getReviewerName();
		this.rating = reviewDTO.getRating();
		this.comment = reviewDTO.getComment();
		this.skillExpert_id = reviewDTO.getSkillExpert_id();
	}
    
}