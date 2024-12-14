package com.example.ReviewService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReviewService.dao.ReviewDao;
import com.example.ReviewService.model.Review;
import com.example.ReviewService.model.ReviewDTO;
@Service
public class ReviewServiceImpl implements ReviewService {

	
	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public void save(ReviewDTO reviewDTO) {
		Review review=new Review(reviewDTO);
		reviewDao.save(review);
		

	}

	@Override
	public List<ReviewDTO> findAll() {
		List<ReviewDTO> reviewList = new ArrayList<>();
		for(Review review: reviewDao.findAll()) {
			ReviewDTO reviewDTO = new ReviewDTO(review);
			reviewList.add(reviewDTO);
			}
		return reviewList;
	}

	@Override
	public void deleteById(String id) {
		reviewDao.delete(id);

	}

	@Override
	public ReviewDTO findById(String id) {
		return new ReviewDTO(reviewDao.findById(id));
	}

}
