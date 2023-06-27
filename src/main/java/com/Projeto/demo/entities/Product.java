package com.Projeto.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private	String name;
	private String description;
	private Double price;
	private String imgURL;
	
	@Transient //Para Spring boot ignorar
	private Set<Category> categories = new HashSet<>();
	
	public Product() {
		
	}	

	public Product(Integer id, String name, String description, Double price, String imgURL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgURL = imgURL;
	}



	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgURL() {
		return imgURL;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	

	
}
