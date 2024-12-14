package com.example.BookingService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookingService.dao.BookingDao;
import com.example.BookingService.dao.BookingRepository;
import com.example.BookingService.model.Booking;
import com.example.BookingService.model.BookingDTO;


@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingDao bookingDao;
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public void save(BookingDTO bookingDTO) {
		Booking booking=new Booking(bookingDTO);
		bookingDao.save(booking);
		
	}

	@Override
	public List<BookingDTO> findAll() {
		List<BookingDTO> bookingList = new ArrayList<>();
		for(Booking booking: bookingDao.findAll()) {
			BookingDTO bookingDTO = new BookingDTO(booking);
			bookingList.add(bookingDTO);
			}
		return bookingList;
	}

	@Override
	public void deleteById(String bookingID) {
		bookingDao.delete(bookingID);
		
	}

	@Override
	public BookingDTO findById(String bookingID) {
		return new BookingDTO(bookingDao.findById(bookingID));
	}

	@Override
	public String generateBookingId() {
		Long val=bookingRepository.findMaxbookingId();
	 	if(val==null)
			val=1001L;
		else
			val=(val+1)+1001;
		String s="BO-SE"+String.valueOf(val);
		return s;
	}

	@Override
	public List<Booking> findByCustomerId(Long customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}

	
	
	
}
