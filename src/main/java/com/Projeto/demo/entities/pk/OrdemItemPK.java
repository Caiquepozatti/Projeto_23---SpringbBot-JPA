package com.Projeto.demo.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.Projeto.demo.entities.Order;
import com.Projeto.demo.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //Pois é uma chave auxiliar de chave primária composta
public class OrdemItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	//Chave primária do item do pedido com referencia a duas classes (Pedido e Produto)
	//Sempre que precisar criar uma classe auxiliar para chave primária composta (pedido e produto) vou colcoar no pacote.pk
	//Essa classe não terá construtores
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemItemPK other = (OrdemItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
}
