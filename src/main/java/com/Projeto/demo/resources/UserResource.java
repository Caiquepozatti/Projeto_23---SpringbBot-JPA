package com.Projeto.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Projeto.demo.entities.User;
import com.Projeto.demo.services.UserService;

//Recurso Web (RESTful)que é implementado por um rest controller
	//RESTful é uma API para criação WEB, e o RestController cria endpoints para o HTTP (são instruções do código para a WEB, e a WEB retorna)
@RestController
//é a instrução que vai buscar as informações do users pelos restcontrollers(https:www.xxx.com.br/users)
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	//GetMapping é para retornar a função public abaixo dele na WEB
	@GetMapping
	//ResponseEntity é um tipo especifico do spring para retornar uma resposta de requisições web
	public ResponseEntity<List<User>> findAll(){
		List<User> u = userService.findAll();	
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping (value = "/{id}") // Pois vai receber o valor do Id para procurar
								  // @PathVariable quer dizer que a variavel vai entrar no HTTL como comando
	public ResponseEntity<User> findById(@PathVariable Long id){
		User u = userService.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping //QUando for inserir algo no banco de dados
				 //@RequestBody é para que o "User obj" seja vinculado ao corpo do HTTP (É utulizado quando usa @Post ou @Put
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = userService.insert(obj);
		//forma adequada de inserir no banco de dados
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); //Código 201 no Post para inserir
	}
	
	//Não consigo deletar clientes que tem pedido, temos como tratar.
	@DeleteMapping (value ="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build(); //Como é um método void, apenas para deletar, nao precisa retornar. Codigo 204 no Postman
	}
	

}
