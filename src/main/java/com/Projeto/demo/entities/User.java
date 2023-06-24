package com.Projeto.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	//Serializable é para que os obejtos possam ser transformados em cadeia de bytes
		// Para que os objetos trafeguem na rede/gravado em arquivos.	
	
@Entity //@Entity serve para indicar que a classe será mapeada oara uma tabela em banco de dados
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
