package ua.springweb.service.service;

import java.util.List;

import ua.springweb.entity.TypeRoom;

public interface TypeRoomService {

	public TypeRoom getTypeByID(int id);
	public void save(TypeRoom typeRoom);
	public TypeRoom getByType(String type);
	public List<TypeRoom> getAll();
}
