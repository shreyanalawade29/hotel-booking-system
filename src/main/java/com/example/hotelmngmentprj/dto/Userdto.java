package com.example.hotelmngmentprj.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Userdto {

	  @NotBlank(message = "Name cannot be blank")
	    private String name;

	    @Email(message = "Enter valid email")
	    private String email;

	    @NotBlank(message = "Phone cannot be blank")
	    private String phone;

	    @NotBlank(message = "Password cannot be blank")
	    private String password;
}
