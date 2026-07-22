package com.example.hotelmngmentprj.model;




	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

	@Entity
	@Data
	public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name cannot be blank")
	    private String name;

	    @Email(message = "Enter valid email")
	    @Column(unique = true)
	    private String email;

	    @NotBlank(message = "Phone cannot be blank")
	    private String phone;

	    @NotBlank(message = "Password cannot be blank")
	    private String password;

	    @NotBlank(message = "Role cannot be blank")
	    private String role;
	}

