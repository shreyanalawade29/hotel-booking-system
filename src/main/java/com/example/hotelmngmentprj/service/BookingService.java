package com.example.hotelmngmentprj.service;

import java.util.List;

import com.example.hotelmngmentprj.model.Booking;

public interface BookingService {

	 Booking insert(Booking booking);

	    Booking search(Long bookingId);

	    Booking update(Booking booking);

	    List<Booking> getAll();

	    List<Booking> getUserBookings(Long userId);
	    void delete(Long bookingId);
}
