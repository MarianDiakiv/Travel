package ua.springweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springweb.entity.TypeRoom;
import ua.springweb.repository.TypeRoomRepository;
import ua.springweb.service.service.TypeRoomService;

@Service
public class TypeRoomServiceImpl implements TypeRoomService {

	@Autowired
	private TypeRoomRepository typeRoomRepository;
	@Override
	public TypeRoom getTypeByID(int id) {
		// TODO Auto-generated method stub
		return typeRoomRepository.findOne(id);
	}

	@Override
	public void save(TypeRoom typeRoom) {
		typeRoomRepository.save(typeRoom);
		
	}

	@Override
	public TypeRoom getByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeRoom> getAll() {
		// TODO Auto-generated method stub
		return typeRoomRepository.findAll();
	}

}
