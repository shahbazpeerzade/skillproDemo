package com.example.ReviewService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReviewService.model.Review;

@Service
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public void save(Review review) {
		reviewRepository.save(review);
		
	}

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public Review findById(String id) {
		return reviewRepository.getById(id);
	}

	@Override
	public void delete(String id) {
      reviewRepository.deleteById(id);		
	}

}
