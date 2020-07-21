package ua.springweb.service.service;

import java.util.Date;
import java.util.List;

import ua.springweb.entity.Order;
import ua.springweb.entity.UserEntity;



public interface OrderService {
void save(Order order);
List<Order> getAll();
Order getById(int id);
List<Order> getAllOrdered(Date date1);
List<Order> getAllOrderedSorted();
List<Order> getOrgerByUser(UserEntity entity, Date date);
void delete(int id);
}
