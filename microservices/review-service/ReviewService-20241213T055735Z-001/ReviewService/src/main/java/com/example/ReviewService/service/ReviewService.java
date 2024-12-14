package com.example.ReviewService.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.ReviewService.model.ReviewDTO;


public interface ReviewService {
	
	public void save(ReviewDTO reviewDTO);
	public List<ReviewDTO> findAll();
	public void deleteById(String id );
	public ReviewDTO findById(String id);


}
