package com.example.hotelmngmentprj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelmngmentprj.model.Booking;
import com.example.hotelmngmentprj.repository.BookingRepository;
import com.example.hotelmngmentprj.repository.RoomRepository;
import com.example.hotelmngmentprj.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class DashboardController {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {

        Map<String, Object> map = new HashMap<>();

        map.put("totalUsers", userRepo.count());
        map.put("totalRooms", roomRepo.count());
        map.put("totalBookings", bookingRepo.count());

        Double revenue = bookingRepo.findAll()
                .stream()
                .filter(b -> b.getTotalPrice() !=null)               
                .mapToDouble(b -> b.getTotalPrice())
                .sum();

        map.put("revenue", revenue);

        return map;
    }
    @GetMapping("/dashboard/revenue")
    public Double revenue() {

        return bookingRepo.findAll()
                .stream()
                .filter(b -> b.getTotalPrice() != null)
                .mapToDouble(Booking::getTotalPrice)
                .sum();
    }
}
