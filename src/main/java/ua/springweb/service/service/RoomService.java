package ua.springweb.service.service;

import java.util.Date;
import java.util.List;

import ua.springweb.entity.Hotel;
import ua.springweb.entity.Room;

public interface RoomService {

	void save(Room room);
	Room getById(int id);
	List<Room> getAll();
	List<Room> getAllRoomByHotel(Hotel hotel);
	List<Room> getRoomByDate(Date date1, Date date2, Hotel hotel );
}
