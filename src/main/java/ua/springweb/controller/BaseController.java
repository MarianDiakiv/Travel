package ua.springweb.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.springweb.domain.LoginRequest;
import ua.springweb.domain.RegisretRequest;

import ua.springweb.entity.Hotel;
import ua.springweb.entity.Order;
import ua.springweb.entity.Room;

import ua.springweb.entity.UserEntity;
import ua.springweb.entity.enumeration.TeacherDegree;
import ua.springweb.mapper.UserMapper;
import ua.springweb.models.DateSearch;

import ua.springweb.models.SearchByCity;
import ua.springweb.repository.OrderRepository;
import ua.springweb.service.service.HotelService;
import ua.springweb.service.service.OrderService;
import ua.springweb.service.service.RoomService;
import ua.springweb.service.service.UserServise;


@Controller
public class BaseController {
	
	@Autowired
	private 	UserServise userServise;

		@Autowired
		private HotelService hotelService;
		@Autowired
		private RoomService roomService;
		@Autowired
		private OrderService orderService;
		
		
		@GetMapping({"/", "/home"})
		public String showHome(Principal principal, Model model) {
			if(principal!=null) {
				model.addAttribute("username", principal.getName());
				UserEntity entity = userServise.findUserByEmail(principal.getName());
				model.addAttribute("user", entity);
				System.out.println(principal.getName());
			}

			return"home";
		}
		@GetMapping("/login")
		public String showLogin(Model model) {
			
			model.addAttribute("userModel", new LoginRequest());
			return"login";
		}	
		
		@GetMapping("/register")
		public String showRegister(Model model) {
			model.addAttribute("registerModel", new RegisretRequest());
			return"register";
		}

		
		@PostMapping("/register")
		public String saveUser(@ModelAttribute("registerModel") @Valid RegisretRequest request, BindingResult result) {
			UserEntity userEntity = new UserEntity();
			System.out.println(request.getEmail());
			 userEntity= UserMapper.registerToUser(request);
			 if(result.hasErrors()) {
				 return"/register";
			 }
			 userServise.saveUser(UserMapper.registerToUser(request));
			
			return"redirect:/login";
		}
		

		
		

		@GetMapping("/profile/{id}")
		public String showProfile( Model model, @PathVariable("id") Integer id) {

			UserEntity entity = userServise.findUserByID(id);  
			model.addAttribute("username", entity.getEmail());
			 System.out.println(entity.getEmail());
			model.addAttribute("user", entity);
			List<Order>  orders = orderService.getOrgerByUser(entity, new Date());
			model.addAttribute("orders", orders);
			return"user/user_profile";
		}
		@GetMapping("/user/cancel/{id}/{oid}")
		public String cansel(@PathVariable("id") int id, @PathVariable("oid") int oid ) {
//			System.out.println(id);
			orderService.delete(oid);
			return"redirect:/profile/"+id;
		}

		
		@GetMapping("/user/edit/{id}")
		public String showEditpage(Model model, @PathVariable("id") Integer id) {
		UserEntity entity =  userServise.findUserByID(id);// при передачі емейлу обірізає .com
//		 model.addAttribute("fileModel", new FileModel());
		 model.addAttribute("user", entity);
			return "user/edit";
		}
		@PostMapping("/user/edit/{id}")
		public String editUserpage(@ModelAttribute("user") UserEntity entity, @PathVariable("id") Integer id) {
			entity.setId(id);
			UserEntity  bd = userServise.findUserByID(id);
			bd.setAge(entity.getAge());
			bd.setEmail(entity.getEmail());
			bd.setFullName(entity.getFullName());
			bd.setId(id);
			userServise.saveUser(bd);
			return "redirect:/profile/"+entity.getId();
		}

		@GetMapping("/hotels")
		public String showHotels(Model model,Principal principal) {
			List<Hotel> hotels = hotelService.getAll();
			UserEntity entity = userServise.findUserByEmail(principal.getName());
			model.addAttribute("user", entity);
			model.addAttribute("username", entity.getEmail());
			model.addAttribute("searchCity", new SearchByCity());
			model.addAttribute("hotelsModel", hotels);
			return "hotels";
		}
		

		@PostMapping("/hotels/city")
		public String searchByCity(@ModelAttribute("searchCity") SearchByCity byCity, Model model, Principal principal) {
			UserEntity entity = userServise.findUserByEmail(principal.getName());
			model.addAttribute("user", entity);
			model.addAttribute("username", entity.getEmail());
			List<Hotel> hotels = hotelService.getByCity(byCity.getCity());
			model.addAttribute("hotelsModel", hotels);
			return "hotels";
		}
		
		@GetMapping("/hotel_details/{id}")
		public String showHotelDatail(@PathVariable("id") int id,  Model model, Principal principal) {
			UserEntity entity = userServise.findUserByEmail(principal.getName());
			model.addAttribute("user", entity);
			
			Hotel hotel = hotelService.getbyId(id);
			model.addAttribute("dateAtrr", new DateSearch());
			model.addAttribute("dateAtrr1", new DateSearch());
			model.addAttribute("hotel", hotel);
			List<Room> rooms = roomService.getAllRoomByHotel(hotel);
			model.addAttribute("roomsByHotel", rooms);

			model.addAttribute("searchCity", new SearchByCity());

			return "hotel_info";
		}

		@PostMapping("/findfreerooms/{id}")
		public String showHotelRoomDatail(@PathVariable("id") int id, @ModelAttribute("dateAtrr") DateSearch dateSearch, Model model, Principal principal) {
			Hotel hotel = hotelService.getbyId(id);
			model.addAttribute("hotel", hotel);
			System.out.println(dateSearch.getDate1());
			System.out.println(dateSearch.getDate2());

			List<Order> orders =  orderService.getAllOrdered(dateSearch.getDate1());
			List<Order> orders2 =  orderService.getAllOrdered(dateSearch.getDate2());
			List<Room> roomsByHotel = roomService.getAllRoomByHotel(hotel);
			List<Order> list = orderService.getAll();
			System.out.println("orderlist "+orders.size());
			System.out.println("allRoom "+roomsByHotel.size());
			
			List<Room> roomToFront = new ArrayList<>(); 
			for(Room r :roomsByHotel) {
				boolean notexist =true; 
				for(Order o:orders) {
					//коли є співпадіння із замовленням та ід готелю відповідне
					if(r.getId()==o.getRoom().getId()&&o.getRoom().getHotel().getId()==id) {
						notexist =false;
					}
					
				}
				for(Order o:orders2) {
					//коли є співпадіння із замовленням та ід готелю відповідне
					if(r.getId()==o.getRoom().getId()&&o.getRoom().getHotel().getId()==id) {
						notexist =false;
					}
					
				}
				if(notexist) {
					//true 
					roomToFront.add(r);
				}
			}
			System.out.println("ROOMS" + roomToFront.size());
			UserEntity entity = userServise.findUserByEmail(principal.getName());
			model.addAttribute("user", entity);
			model.addAttribute("roomsByHotel", roomToFront);
			model.addAttribute("dateAtrr", dateSearch);
			model.addAttribute("dateAtrr1", new DateSearch());
			model.addAttribute("searchCity", new SearchByCity());

			return "hotel_info";
		}
		

		@PostMapping("/order/{id}")
		public String order( @PathVariable("id") int id, @ModelAttribute("dateAtrr") DateSearch dateS,
				
				Principal principal, Model model  ) {
			Room room = roomService.getById(id);
			UserEntity user = userServise.findUserByEmail(principal.getName());
			Order order = new Order();
			order.setRoom(room);
			order.setUserEntity(user);
			order.setDateOfSettlement(dateS.getDate1());
			order.setDepartureDate(dateS.getDate2());

			orderService.save(order);
			List<Hotel> hotels = hotelService.getAll();
			model.addAttribute("searchCity", new SearchByCity());
			model.addAttribute("hotelsModel", hotels);

			return "redirect:/hotels";
		}

}
