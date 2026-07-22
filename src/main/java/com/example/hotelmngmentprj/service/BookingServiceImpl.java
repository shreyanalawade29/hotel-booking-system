package com.example.hotelmngmentprj.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.hotelmngmentprj.exception.ResourceNotFoundException;
import com.example.hotelmngmentprj.model.Booking;
import com.example.hotelmngmentprj.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	 @Autowired
	    @Qualifier("bookingRepo")
	    private BookingRepository bookingRepo;

	    @Override
	    public Booking insert(Booking booking) {
	        return bookingRepo.save(booking);
	    }

	    @Override
	    public Booking search(Long bookingId) {
	        return bookingRepo.findById(bookingId).orElseThrow(() ->
            new ResourceNotFoundException(
                    "Booking Not Found"));
	    }

	    @Override
	    public Booking update(Booking booking) {

	        Booking oldBooking =
	                bookingRepo.findById(booking.getId())
	                        .orElse(null);

	        if(oldBooking != null) {

	            oldBooking.setStatus(booking.getStatus());

	            return bookingRepo.save(oldBooking);
	        }

	        return null;
	    }

	    @Override
	    public List<Booking> getAll() {
	        return bookingRepo.findAll();
	    }

	    @Override
	    public List<Booking> getUserBookings(Long userId) {
	        return bookingRepo.findByUser_Id(userId);
	    }
	    @Override
	    public void delete(Long bookingId) {

	        bookingRepo.deleteById(bookingId);
	    }
}
