package com.example.hotelmngmentprj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.hotelmngmentprj.model.User;
import com.example.hotelmngmentprj.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories("com.example.hotelmngmentprj.repository")
@EntityScan("com.example.hotelmngmentprj.model")
public class HotelmngmentprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmngmentprjApplication.class, args);
	}
	@Bean
	CommandLineRunner createAdmin(UserRepository repo,
	                              PasswordEncoder encoder) {
	    return args -> {

	        System.out.println("Creating admin check...");

	        if(repo.findByEmail("admin@gmail.com").orElse(null) == null) {

	            User admin = new User();

	            admin.setName("Administrator");
	            admin.setEmail("admin@gmail.com");
	            admin.setPhone("9999999999");
	            admin.setPassword(
	                    encoder.encode("admin123"));
	            admin.setRole("ADMIN");

	            repo.save(admin);

	            System.out.println("Admin Created");
	        }
	        else {
	            System.out.println("Admin Already Exists");
	        }
	    };
	}
}
