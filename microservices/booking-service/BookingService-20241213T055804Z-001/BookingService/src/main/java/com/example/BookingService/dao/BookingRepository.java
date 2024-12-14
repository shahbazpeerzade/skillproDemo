package com.example.BookingService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BookingService.model.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, String>{
	@Query("select count(bookingId) from Booking")
	public Long findMaxbookingId();
	public List<Booking> findByCustomerId(Long customerId);
 

}
