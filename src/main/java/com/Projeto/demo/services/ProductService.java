package com.Projeto.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto.demo.entities.Product;
import com.Projeto.demo.repositories.ProductRepository;

@Service //Para classificar como camada de serviço para utilizar o Autowired (component registration)
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long Id) {
		Optional<Product> obj = productRepository.findById(Id);
		return obj.	get();
	}
	

}
