package com.example.BookingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingService.model.Booking;
import com.example.BookingService.model.BookingDTO;
import com.example.BookingService.service.BookingService;



@RestController
public class BookingController {
@Autowired
BookingService bookingService;
	
	
	@GetMapping(value="/booking",produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<BookingDTO> showAll(){
			
			return bookingService.findAll();
		}
	
	@PostMapping(value="/booking",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody BookingDTO bookingDTO) { 

		
		bookingDTO.setBookingId(bookingService.generateBookingId());
		Long abc=(long) 103;
		bookingDTO.setCustomerId(abc);

		bookingService.save(bookingDTO);
		return "Booked sucessfuly Successfully";
	}
	
	@GetMapping(value="/booking/{bookingId}",produces=MediaType.APPLICATION_JSON_VALUE)
    public BookingDTO findById(@PathVariable String bookingId){
		System.out.println(bookingId);
		return bookingService.findById(bookingId);
	}
	
	
	@PutMapping(value="/Editbooking/{bookingId}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String edit(@PathVariable String bookingId,@RequestBody BookingDTO bookingDTO) {
		BookingDTO bookingEdit=bookingService.findById(bookingId);
		
		bookingService.save(bookingEdit);
		return "booking edited";
	}
	
	
	@DeleteMapping(value="/deletebooking/{bookingId}",produces=MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@PathVariable String bookingId){
		bookingService.deleteById(bookingId);
		return "booking Deleted";
	}

	@GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingsByCustomerId(@PathVariable Long customerId) {
        List<Booking> bookings = bookingService.findByCustomerId(customerId);
        return ResponseEntity.ok(bookings);
    }
	
}
