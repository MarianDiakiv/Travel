package ua.springweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ua.springweb.entity.TypeRoom;

//@Repository
public interface TypeRoomRepository extends JpaRepository<TypeRoom, Integer> {

//	@Query("Sececl t  from TypeRoom t Where t.typeRoom=:type")
//	TypeRoom getTypeRoomByType(@Param("type") String type);
}
