package com.example.hotelmngmentprj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.hotelmngmentprj.dto.Logindto;
import com.example.hotelmngmentprj.dto.Userdto;
import com.example.hotelmngmentprj.model.User;
import com.example.hotelmngmentprj.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/users")
    public User insert(@RequestBody Userdto ud) {
        return userService.insert(ud);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User search(@PathVariable Long id) {
        return userService.search(id);
    }

   

    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

  
    
    
    @PostMapping("/login")
    public User login(@RequestBody Logindto dto,
                      HttpServletRequest request) {

        Authentication au =
                manager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getEmail(),
                                dto.getPassword()));

        User user =
                userService.searchByEmail(au.getName());

        SecurityContextHolder
                .getContext()
                .setAuthentication(au);

        request.getSession(true);

        return user;
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String,String>>
    logout(HttpServletRequest request,
           HttpServletResponse response){

        request.getSession().invalidate();

        Cookie cookie =
                new Cookie("JSESSIONID", null);

        cookie.setMaxAge(0);
        cookie.setPath("/");

        response.addCookie(cookie);

        Map<String,String> map =
                new HashMap<>();

        map.put("message","Logged Out");

        return new ResponseEntity<>
                (map,HttpStatus.OK);
    }

}
