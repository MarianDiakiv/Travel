package ua.springweb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.springweb.entity.Order;
//import ua.springweb.entity.Order;
import ua.springweb.entity.Room;
import ua.springweb.entity.UserEntity;

public interface OrderRepository extends JpaRepository<Order, Integer> {

//	@Query("Select o From Order o Where :date1 between o.dateOfSettlement and o.departureDate "
//			+ "OR :date2 between o.dateOfSettlement and o.departureDate" )
//	List<Order> getAllOrdered(@Param("date1") Date date1, @Param("date2") Date date2);
	
	@Query("Select o From Order o Where :date1 between o.dateOfSettlement and o.departureDate "
			 )// працює але чомусь тіки із одним бетвім тому створити для іншої ддати і в контролері додати ще одну перевірку 
	List<Order> getAllOrdered1(@Param("date1") Date date1 );
	@Query("Select o From Order o ORDER BY o.dateOfSettlement DESC")
	List<Order> getAllOrderedSorted();
	
	@Query("Select o from Order o Where o.userEntity = :user and o.dateOfSettlement>:date")
	List<Order> getOrgerByUser(@Param("user")UserEntity entity, @Param("date")Date date);
}
