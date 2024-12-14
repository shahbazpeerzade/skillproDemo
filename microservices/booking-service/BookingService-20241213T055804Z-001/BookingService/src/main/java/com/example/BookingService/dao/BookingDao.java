package com.example.BookingService.dao;

import java.util.List;

import com.example.BookingService.model.Booking;


public interface BookingDao {
	public void save(Booking booking);
	public List<Booking> findAll();
	public Booking findById(String bookingId);
	public void delete(String bookingId);
	
}
