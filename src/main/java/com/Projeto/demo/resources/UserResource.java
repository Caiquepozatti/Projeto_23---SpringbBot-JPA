package com.Projeto.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.demo.entities.User;

//Recurso Web (RESTful)que é implementado por um rest controller
	//RESTful é uma API para criação WEB, e o RestController cria endpoints para o HTTP (são instruções do código para a WEB, e a WEB retorna)
@RestController
//é a instrução que vai buscar as informações do users pelos restcontrollers(https:www.xxx.com.br/users)
@RequestMapping(value = "/users")
public class UserResource {
	
	//GetMapping é para retornar a função public abaixo dele na WEB
	@GetMapping
	//ResponseEntity é um tipo especifico do spring para retornar uma resposta de requisições web
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Caique Pozatti","caca@gmail.com","997417581","12345");		
		return ResponseEntity.ok().body(u);
	}
	
	

}
