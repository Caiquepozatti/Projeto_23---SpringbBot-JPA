package com.Projeto.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto.demo.entities.Category;
import com.Projeto.demo.repositories.CategoryRepository;

@Service //Para classificar como camada de serviço para utilizar o Autowired (component registration)
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long Id) {
		Optional<Category> obj = categoryRepository.findById(Id);
		return obj.	get();
	}
	

}
