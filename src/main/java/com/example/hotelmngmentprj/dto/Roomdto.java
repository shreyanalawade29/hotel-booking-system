package com.example.hotelmngmentprj.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Roomdto {

	
	 @NotBlank
	    private String roomNumber;

	    @NotBlank
	    private String roomType;

	    @NotBlank
	    private String description;

	    @NotNull
	    private Double price;

	    @NotNull
	    private Integer capacity;

	    @NotBlank
	    private String status;

	    private String imageUrl;
}
