package ua.springweb.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springweb.entity.Hotel;
import ua.springweb.entity.Order;
import ua.springweb.entity.Room;
import ua.springweb.entity.TypeRoom;
import ua.springweb.entity.UserEntity;
import ua.springweb.service.service.HotelService;
import ua.springweb.service.service.OrderService;
import ua.springweb.service.service.RoomService;
import ua.springweb.service.service.TypeRoomService;
import ua.springweb.service.service.UserServise;

@Controller
public class AdminController {

	@Autowired
	private TypeRoomService typeRoomService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserServise userServise;
	
	/*@GetMapping("/page/{id}")
	public String showAdminPage(Model model) {
		
		model.addAttribute("typeRoom", new TypeRoom());
		model.addAttribute("city", new TypeRoom());
		return "admin/adminPage";
	}*/
	@GetMapping("/adminBoard/addRoomType")
	public String showAddRoomType(Model model,Principal principal) {
		UserEntity entity = userServise.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		List<TypeRoom> typeRooms = typeRoomService.getAll();
		model.addAttribute("types", typeRooms);
		model.addAttribute("roomType", new TypeRoom());
		return"admin/room_type";
	}
	@PostMapping("/adminBoard/addRoomType")
	public String addRoomType(@ModelAttribute("roomType")  TypeRoom typeRoom ,Model model) {
		model.addAttribute("roomType", new TypeRoom());
		typeRoomService.save(typeRoom);
		return"redirect:/adminBoard/addRoomType";
	}
	
	@GetMapping("/adminBoard/createHotel")
	public String showCreateHotel(Model model,Principal principal) {
		model.addAttribute("hotel",new Hotel());
		UserEntity entity = userServise.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		return  "admin/create_hotel";
	}
	@PostMapping("/adminBoard/createHotel")
	public String getCreateHotel(@ModelAttribute("hotel") Hotel hotel , Model model ) {
		
		System.out.println("NAME"+ hotel.getName());
		hotelService.save(hotel);
		model.addAttribute("hotel",new Hotel());
		return  "redirect:/adminBoard/createHotel";
	}
	
	@GetMapping("/adminBoard/editHotel/{id}")
	public String getEditHotelPage( @PathVariable("id") int id,  Model model, Principal principal) {
		UserEntity entity = userServise.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		Hotel hotel  = hotelService.getbyId(id);
		model.addAttribute("hotelModel", hotel);
		List<TypeRoom> typeRoom = typeRoomService.getAll();
		model.addAttribute("roomModel", new Room());
		Map<TypeRoom,String> map = new HashMap<>();
		for(TypeRoom t:typeRoom) {
			map.put(t, t.getTypeRoom());
		}
		model.addAttribute("roomTypes", map);
		List<Room> rooms = roomService.getAllRoomByHotel(hotel);
		model.addAttribute("roomsByHotel", rooms);
		return"admin/edit_hotel";
	}
	@PostMapping("/adminBoard/editHotel/{id}")
	public String saveEditHotelPage(@PathVariable("id") int id, @ModelAttribute("hotelModel")  Hotel hotel, Model model) {
//		Hotel hotel  = hotelService.getbyId(id);
//		model.addAttribute("hotelModel", hotel);
//		List<TypeRoom> typeRoom = typeRoomService.getAll();
//		model.addAttribute("roomTypes", typeRoom);
		System.out.println(hotel.getId());
		hotel.setId(id);
		hotelService.save(hotel);
		return"redirect:/hotels";
	}
	@PostMapping("/adminBoard/addRoom/{id}")
	public String addRoomHotelPage(@PathVariable("id") int id, @ModelAttribute("roomModel")  Room room , Model model) {
//		Hotel hotel  = hotelService.getbyId(id);
//		model.addAttribute("hotelModel", hotel);
//		List<TypeRoom> typeRoom = typeRoomService.getAll();
//		model.addAttribute("roomTypes", typeRoom);
		Hotel hotel = hotelService.getbyId(id);
		room.setHotel(hotel);
		room.setId(0);// 
		 System.out.println(room.getId());
		roomService.save(room);
		return"redirect:/hotels";
	}
	@GetMapping("/adminBoard/showAllOrdering")
	public String  showOrdering(Model model, Principal principal) {
		List<Order> orders = orderService.getAllOrderedSorted();
		UserEntity entity = userServise.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		model.addAttribute("orders", orders);
		return"admin/all_orders";
	}
	
	
	
	
	
	
	
	
	
	
}
