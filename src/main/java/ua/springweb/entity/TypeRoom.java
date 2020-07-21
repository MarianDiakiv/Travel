package ua.springweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="room_type_table")
public class TypeRoom {
	public TypeRoom() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="type_room")
	private String typeRoom;
	
	@OneToMany(mappedBy="typeRoom")
	private List<Room> rooms = new ArrayList<>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
