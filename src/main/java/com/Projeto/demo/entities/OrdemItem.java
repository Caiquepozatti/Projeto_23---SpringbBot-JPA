package com.Projeto.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.Projeto.demo.entities.pk.OrdemItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_OrdemItem")
public class OrdemItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId //Puxa uma chave primária composta e sempre instanciar a classe composta.
	private OrdemItemPK id = new OrdemItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrdemItem() {
		
	}

	public OrdemItem(Order order, Product product,Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore //Pois como temos uma classe auxiliar, temos que colocar no get
	public Order getOrder() {
		return id.getOrder();
	}
	

	public Product getProduct() {
		return id.getProduct();
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		OrdemItem other = (OrdemItem) obj;
		return Objects.equals(id, other.id);
	}
	
}
