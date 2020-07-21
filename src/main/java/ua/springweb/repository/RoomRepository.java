package ua.springweb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.springweb.entity.Hotel;
import ua.springweb.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

	@Query("Select r from Room r where r.hotel=:hotel")
	List<Room> getAllRoomByHotel(@Param("hotel") Hotel hotel);

//	@Query("Select r from Room r JOIN r.hotel h Where h.id=:idhotel  "
//			+ "JOIN r.orders o "
//			+ "where :date1 NOT BETWEEN o.dateOfSettlement AND o.departureDate AND :date2 "
//			+ "NOT BETWEEN o.dateOfSettlement AND o.departureDate"
//			)

//	List<Room> getAllFreeRooms(@Param("idhotel")int idhotel);
//	@Param("date1") Date date1, @Param("date2")Date date2,
//	@Query("Select r from Room r, Order o, Hotel h Where r.hotel=:hotel AND :date1 NOT BETWEEN o.dateOfSettlement AND o.departureDate  ")
//	List<Room> getAllFreeRooms(@Param("hotel") Hotel hotel, @Param("date1") Date date1 );
//	@Query("Select r from Room r, Order o, Hotel h Where r.hotel=:hotel "
//			+ "AND  not :date1  = o.dateOfSettlement"
//			)
//	List<Room> getAllFreeRooms(@Param("hotel") Hotel hotel, @Param("date1") Date date1 );
//	@Query("select r from Order o Inner Join Room r on o.room = r Where r.hotel =:hotel and o.dateOfSettlement not like :date1 ")
//	List<Room> getAllFreeRooms(@Param("hotel") Hotel hotel, @Param("date1") Date date1 );
}
