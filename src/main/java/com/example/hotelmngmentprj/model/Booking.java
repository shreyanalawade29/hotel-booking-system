package com.example.hotelmngmentprj.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Booking {
	
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "room_id")
	    private Room room;

	    @NotNull(message = "Check In date required")
	    private LocalDate checkInDate;

	    @NotNull(message = "Check Out date required")
	    private LocalDate checkOutDate;

	    private Integer guests;

	    private Double totalPrice;

	    private String status;

		

}
