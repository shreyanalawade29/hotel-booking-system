package com.example.hotelmngmentprj.model;



	

	import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

	@Entity
	
	@Data
	public class Room {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Room number cannot be blank")
	    private String roomNumber;

	    @NotBlank(message = "Room type cannot be blank")
	    private String roomType;

	    @NotBlank(message = "Description cannot be blank")
	    private String description;

	    @NotNull(message = "Price cannot be null")
	    private Double price;

	    @NotNull(message = "Capacity cannot be null")
	    private Integer capacity;

	    @NotBlank(message = "Status cannot be blank")
	    private String status;

	    
	}

