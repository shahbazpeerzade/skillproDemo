package com.example.ReviewService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.ReviewService.model.ReviewDTO;
import com.example.ReviewService.service.ReviewService;

@RestController
public class ReviewController {
	
@Autowired
ReviewService reviewService;

	@GetMapping(value="/review",produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<ReviewDTO> showAll(){
			
			return reviewService.findAll();
		}
	
	@PostMapping(value="/review",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody ReviewDTO reviewDTO) {
		reviewService.save(reviewDTO);
		return "review saved Successfully";
	}
	
	@GetMapping(value="/review/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ReviewDTO findById(@PathVariable String id){
		
		return reviewService.findById(id);
	}

	@PutMapping(value="/editReview/{Id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String edit(@PathVariable String id,@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO Editreview=reviewService.findById(id);
		
         reviewService.save(Editreview);
		return "review  edited";
		
		
	}
	
	@DeleteMapping(value="/deletereview/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@PathVariable String id){
		reviewService.deleteById(id);
		return "review Deleted";
	}

	

}
