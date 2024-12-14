package com.example.ReviewService.dao;

import java.util.List;

import com.example.ReviewService.model.Review;

public interface ReviewDao {
	public void save(Review review);
	public List<Review> findAll();
	public Review findById(String id);
	public void delete(String id);
}
