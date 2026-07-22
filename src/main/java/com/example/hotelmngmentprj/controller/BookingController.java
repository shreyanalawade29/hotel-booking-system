package com.example.hotelmngmentprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hotelmngmentprj.model.Booking;
import com.example.hotelmngmentprj.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public Booking insert(@RequestBody Booking booking) {
        return bookingService.insert(booking);
    }

    @GetMapping("/bookings")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/bookings/{id}")
    public Booking search(@PathVariable Long id) {
        return bookingService.search(id);
    }

    @PutMapping("/bookings")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @GetMapping("/bookings/user/{userId}")
    public List<Booking> getUserBookings(
            @PathVariable Long userId) {

        return bookingService.getUserBookings(userId);
    }
    @DeleteMapping("/bookings/{id}")
    public String delete(@PathVariable Long id) {

        bookingService.delete(id);

        return "Booking Deleted Successfully";
    }
    @PutMapping("/bookings/status/{id}/{status}")
    public Booking updateStatus(
            @PathVariable Long id,
            @PathVariable String status) {

        Booking booking =
                bookingService.search(id);

        booking.setStatus(status);

        return bookingService.update(booking);
    }
}
