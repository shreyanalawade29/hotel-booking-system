package com.example.hotelmngmentprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.hotelmngmentprj.exception.ResourceNotFoundException;
import com.example.hotelmngmentprj.model.Room;
import com.example.hotelmngmentprj.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	  @Autowired
	    @Qualifier("roomRepo")
	    private RoomRepository roomRepo;

	    @Override
	    public Room insert(Room room) {

	        return roomRepo.save(room);
	    }

	    @Override
	    public Room search(Long id) {

	    	Room room = roomRepo.findById(id)
	    	        .orElseThrow(() ->
	    	        new ResourceNotFoundException(
	    	                "Room Not Found"));
	        return room;
	    }

	    @Override
	    public Room update(Room room) {

	        Room oldRoom =
	                roomRepo.findById(room.getId())
	                        .orElse(null);

	        if(oldRoom != null) {

	            oldRoom.setRoomNumber(room.getRoomNumber());
	            oldRoom.setRoomType(room.getRoomType());
	            oldRoom.setDescription(room.getDescription());
	            oldRoom.setPrice(room.getPrice());
	            oldRoom.setCapacity(room.getCapacity());
	            oldRoom.setStatus(room.getStatus());
	            

	            return roomRepo.save(oldRoom);
	        }

	        return null;
	    }

	    @Override
	    public List<Room> getAll() {

	        return roomRepo.findAll();
	    }

	    @Override
	    public List<Room> searchByType(String roomType) {

	        return roomRepo.findByRoomType(roomType);
	    }
	    @Override
	    public void delete(Long id) {

	        roomRepo.deleteById(id);
	    }
}
