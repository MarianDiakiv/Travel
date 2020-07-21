package ua.springweb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springweb.entity.Order;
import ua.springweb.entity.UserEntity;
//import ua.springweb.entity.Order;
import ua.springweb.repository.OrderRepository;
import ua.springweb.service.service.OrderService;

@Service
public  class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
		return orderRepository.getOne(id);
	}

	@Override
	public List<Order> getAllOrdered(Date date1) {
		// TODO Auto-generated method stub
		return orderRepository.getAllOrdered1(date1);
	}

	@Override
	public List<Order> getAllOrderedSorted() {
		// TODO Auto-generated method stub
		return orderRepository.getAllOrderedSorted();
	}

	@Override
	public List<Order> getOrgerByUser(UserEntity entity, Date date) {
		// TODO Auto-generated method stub
		return orderRepository.getOrgerByUser(entity, date);
	}

	@Override
	public void delete(int id) {
		orderRepository.delete(id);
		
	}
	
	

}
