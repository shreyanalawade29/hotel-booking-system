package com.example.hotelmngmentprj.service;

import java.util.List;

import com.example.hotelmngmentprj.model.Room;

public interface RoomService {

	Room insert(Room room);

    Room search(Long id);

    Room update(Room room);

    List<Room> getAll();

    List<Room> searchByType(String roomType);
    void delete(Long id);
}
