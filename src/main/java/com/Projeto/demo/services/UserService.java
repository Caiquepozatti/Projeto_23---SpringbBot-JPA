package com.Projeto.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto.demo.entities.User;
import com.Projeto.demo.repositories.UserRepository;

@Service //Para classificar como camada de serviço para utilizar o Autowired (component registration)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long Id) {
		Optional<User> obj = userRepository.findById(Id);
		return obj.	get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
		
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = userRepository.getReferenceById(id); //getTeferenceById ele nao busca no banco de dados, ele só deixa instanciado sendo mais eficiente. O findById busca direto no banco de dados e ja faz a alteração.
		updateData(entity, obj);
		return userRepository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
