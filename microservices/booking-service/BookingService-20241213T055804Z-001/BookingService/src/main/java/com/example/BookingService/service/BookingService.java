package com.example.BookingService.service;

import java.util.List;

import com.example.BookingService.model.Booking;
import com.example.BookingService.model.BookingDTO;


public interface BookingService {

	public void save(BookingDTO bookingDTO);
	public List<BookingDTO> findAll();
	public void deleteById(String bookingID);
	public BookingDTO findById(String bookingID);
	public String generateBookingId();
	public List<Booking> findByCustomerId(Long customerId);

}
