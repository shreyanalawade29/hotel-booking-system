package com.example.hotelmngmentprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hotelmngmentprj.dto.Userdto;
import com.example.hotelmngmentprj.exception.ResourceNotFoundException;
import com.example.hotelmngmentprj.model.User;
import com.example.hotelmngmentprj.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {

    @Autowired
    @Qualifier("userRepo")
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User insert(Userdto ud) {

        User user = userRepo.findByEmail(ud.getEmail()).orElse(null);

        if(user != null)
            throw new RuntimeException("User already exists!");

        User u = new User();

        u.setName(ud.getName());
        u.setEmail(ud.getEmail());
        u.setPhone(ud.getPhone());
        u.setPassword(passwordEncoder.encode(ud.getPassword()));
        u.setRole("USER");

        return userRepo.save(u);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User search(Long id) {
        return userRepo.findById(id) .orElseThrow(() ->
        new ResourceNotFoundException("User Not Found"));
    }

    @Override
    public User searchByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    
    @Override
    public void delete(Long id) {

        User user = search(id);

        if ("ADMIN".equals(user.getRole())) {
            throw new RuntimeException("Admin cannot be deleted");
        }

        userRepo.deleteById(id);

    }

    
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

}
