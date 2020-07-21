package ua.springweb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springweb.entity.Hotel;
import ua.springweb.entity.Room;
import ua.springweb.repository.RoomRepository;
import ua.springweb.service.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	@Override
	public void save(Room room) {
		// TODO Auto-generated method stub
		roomRepository.save(room);
	}

	@Override
	public Room getById(int id) {
		// TODO Auto-generated method stub
		return roomRepository.findOne(id);
	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	@Override
	public List<Room> getAllRoomByHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return roomRepository.getAllRoomByHotel(hotel);
	}

	@Override
	public List<Room> getRoomByDate(Date date1, Date date2, Hotel hotel) {
		// TODO Auto-generated method stub
//		return roomRepository.getAllFreeRooms( hotel,date1);
		return null;
	}
	
	

}
