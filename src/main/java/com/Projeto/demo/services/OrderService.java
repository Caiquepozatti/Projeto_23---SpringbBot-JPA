package com.Projeto.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto.demo.entities.Order;
import com.Projeto.demo.repositories.OrderRepository;

@Service //Para classificar como camada de serviço para utilizar o Autowired (component registration)
public class OrderService {
	
	@Autowired
	private OrderRepository userRepository;
	
	public List<Order> findAll(){
		return userRepository.findAll();
	}
	
	public Order findById(Long Id) {
		Optional<Order> obj = userRepository.findById(Id);
		return obj.get();
	}
	

}
