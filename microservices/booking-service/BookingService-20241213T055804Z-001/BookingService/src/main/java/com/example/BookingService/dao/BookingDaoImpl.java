package com.example.BookingService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookingService.model.Booking;
@Service
public class BookingDaoImpl implements BookingDao {

	
	@Autowired
	BookingRepository bookingRepository;
	@Override
	public void save(Booking booking) {
		bookingRepository.save(booking);

	}

	@Override
	public List<Booking> findAll() {
		
		return bookingRepository.findAll();
	}

	@Override
	public Booking findById(String bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.getById(bookingId);
	}

	@Override
	public void delete(String bookingId) {
		bookingRepository.deleteById(bookingId);
		
	}

}
