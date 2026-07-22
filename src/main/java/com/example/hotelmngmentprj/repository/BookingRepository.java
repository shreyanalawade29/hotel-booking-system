package com.example.hotelmngmentprj.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelmngmentprj.model.Booking;

@Repository
@Qualifier("bookingRepo")
public interface BookingRepository  extends JpaRepository<Booking, Long> {

	List<Booking> findByUser_Id(Long userId);
	   
}
