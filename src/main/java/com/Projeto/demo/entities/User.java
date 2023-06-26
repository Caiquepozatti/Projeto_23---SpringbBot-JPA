package com.Projeto.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

	//Serializable é para que os obejtos possam ser transformados em cadeia de bytes
		// Para que os objetos trafeguem na rede/gravado em arquivos.	
	
@Entity //@Entity serve para indicar que a classe será mapeada para uma tabela em banco de dados
@Table(name = "tb_user") //@Table para trocar o nome User pois pode dar conflito
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //Qual vai ser a minha chave primário no banco de dados, nesse caso o id será minha chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Como id é uma chave numérica vai ser auto-incrementável no banco de dados.
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	
	@JsonIgnore //Para ignorar o loopin entre classe "User" e "Order"  (List<Order> e User cliente). Pode colocar essa anotação em apenas uma classe
		//JsonIgnore no "User" traz a lista de pedidos feito pelo usuário, e no "Order" traz os dados do cliente. JsonIgonre traz essa opção
		//Mas só pq no "application.proprerties" é igual a true, se não ele nao puxa.
	@OneToMany(mappedBy = "client") //É para relacionarmos a classe Order e User no banco de dados (OneToMany- pq apenas uma classe Users para muitos pedidos) 
	private List<Order> order = new ArrayList<>();	
	
	public User () {
		
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ "]";
	}	
}
