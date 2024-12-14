package com.example.ReviewService.model;

public class ReviewDTO {

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
		public Long getSkillExpert_id() {
			return skillExpert_id;
		}
		public void setSkillExpert_id(Long skillExpert_id) {
			this.skillExpert_id = skillExpert_id;
		}
		@Override
		public String toString() {
			return "ReviewDTO [id=" + id + ", reviewerName=" + reviewerName + ", rating=" + rating + ", comment="
					+ comment + ", skillExpert_id=" + skillExpert_id + "]";
		}
		public ReviewDTO(Long id, String reviewerName, int rating, String comment, Long skillExpert_id) {
			super();
			this.id = id;
			this.reviewerName = reviewerName;
			this.rating = rating;
			this.comment = comment;
			this.skillExpert_id = skillExpert_id;
		}
		
		public ReviewDTO(Review review) {
			super();
			this.id = review.getId();
			this.reviewerName = review.getReviewerName();
			this.rating = review.getRating();
			this.comment = review.getComment();
			this.skillExpert_id = review.getskillExpert_id();
		}
		public ReviewDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
