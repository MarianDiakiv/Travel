package ua.springweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.springweb.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
 
	@Query("Select h from Hotel h where h.city=:city")
	List<Hotel> getByCity( @Param("city")String city);
}
