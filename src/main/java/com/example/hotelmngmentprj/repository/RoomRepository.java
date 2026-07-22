package com.example.hotelmngmentprj.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelmngmentprj.model.Room;

@Repository
@Qualifier("roomRepo")
public interface RoomRepository extends JpaRepository<Room, Long> {

	 List<Room> findByRoomType(String roomType);


}
