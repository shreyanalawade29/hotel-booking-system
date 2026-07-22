package com.example.hotelmngmentprj.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hotelmngmentprj.model.Room;
import com.example.hotelmngmentprj.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {

	
	@Autowired
    private RoomService roomService;

    @PostMapping("/rooms")
    public Room insert(@RequestBody Room room) {

        return roomService.insert(room);
    }

    @GetMapping("/rooms")
    public List<Room> getAll() {

        return roomService.getAll();
    }

    @GetMapping("/rooms/{id}")
    public Room search(@PathVariable Long id) {

        return roomService.search(id);
    }

    @PutMapping("/rooms")
    public Room update(@RequestBody Room room) {

        return roomService.update(room);
    }

    @GetMapping("/rooms/type/{roomType}")
    public List<Room> searchByType(
            @PathVariable String roomType) {

        return roomService.searchByType(roomType);
    }
    @DeleteMapping("/rooms/{id}")
    public String delete(@PathVariable Long id) {

        roomService.delete(id);

        return "Room Deleted Successfully";
    }
}
