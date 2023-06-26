package com.Projeto.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.demo.entities.Order;
import com.Projeto.demo.services.OrderService;

//Recurso Web (RESTful)que é implementado por um rest controller
	//RESTful é uma API para criação WEB, e o RestController cria endpoints para o HTTP (são instruções do código para a WEB, e a WEB retorna)
@RestController
//é a instrução que vai buscar as informações do users pelos restcontrollers(https:www.xxx.com.br/users)
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	//GetMapping é para retornar a função public abaixo dele na WEB
	@GetMapping
	//ResponseEntity é um tipo especifico do spring para retornar uma resposta de requisições web
	public ResponseEntity<List<Order>> findAll(){
		List<Order> u = orderService.findAll();	
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping (value = "/{id}") // Pois vai receber o valor do Id para procurar
								  // @PathVariable quer dizer que a variavel vai entrar no HTTL como comando
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order u = orderService.findById(id);
		return ResponseEntity.ok(u);
	}
}
