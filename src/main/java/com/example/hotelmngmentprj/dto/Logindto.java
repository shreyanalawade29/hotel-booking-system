package com.example.hotelmngmentprj.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Logindto {

	 @Email(message = "Enter valid email")
	    private String email;

	    @NotBlank(message = "Password cannot be blank")
	    private String password;
}
