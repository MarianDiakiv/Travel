package ua.springweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springweb.entity.Hotel;
import ua.springweb.repository.HotelRepository;
import ua.springweb.service.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel getbyId(int id) {
		// TODO Auto-generated method stub
		return hotelRepository.findOne(id);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public void save(Hotel hotel) {
		// TODO Auto-generated method stub
		System.out.println(hotel.getName());
		hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getByCity(String city) {
		// TODO Auto-generated method stub
		return hotelRepository.getByCity(city);
	}
	
	

}
