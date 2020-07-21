package ua.springweb.entity;

import javax.persistence.Table;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int number;
//	private String type; зробити таБлицю
	@Column(name="price", columnDefinition = "DECIMAL(6,2)")
	private BigDecimal price ;
	
	@ManyToOne
	@JoinColumn(name="type_room_id")
	private TypeRoom typeRoom;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@OneToMany(mappedBy="room")
	private List<Order> orders = new ArrayList<>();

	public Room() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public TypeRoom getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(TypeRoom typeRoom) {
		this.typeRoom = typeRoom;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	

}
