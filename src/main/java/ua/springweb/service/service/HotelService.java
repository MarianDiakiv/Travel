package ua.springweb.service.service;

import java.util.List;

import ua.springweb.entity.Hotel;

public interface HotelService {
Hotel getbyId(int id);
List<Hotel> getAll();
void save(Hotel hotel);
List<Hotel> getByCity(String city);
}
