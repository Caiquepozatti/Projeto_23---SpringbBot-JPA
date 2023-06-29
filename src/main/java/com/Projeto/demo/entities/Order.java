package com.Projeto.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.Projeto.demo.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//Serializable é para que os obejtos possam ser transformados em cadeia de bytes
		// Para que os objetos trafeguem na rede/gravado em arquivos.	
	
@Entity //@Entity serve para indicar que a classe será mapeada para uma tabela em banco de dados
@Table(name = "tb_order")
public class Order implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Id //Qual vai ser a minha chave primário no banco de dados, nesse caso o id será minha chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Como id é uma chave numérica vai ser auto-incrementável no banco de dados.
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T-HH:mm:ss'Z", timezone = "GMT")
	private Instant moment;
	private Integer orderStatus;
	
	//@JsonIgnore //Para ignorar o loopin entre classe "User" e "Order"  (List<Order> e User cliente). Pode colocar essa anotação em apenas uma classe
		//JsonIgnore no "User" traz a lista de pedidos feito pelo usuário, e no "Order" traz os dados do cliente. JsonIgonre traz essa opção
		//Mas só pq no "application.proprerties" é igual a true, se não ele nao puxa.
	@ManyToOne //É para relacionarmos a classe Order e User no banco de dados (ManyToOne- pq existem muitas orders para um cliente) 
	@JoinColumn(name = "client_id") //Para criar uma coluna "client_id" no banco de dados "Order" relacionado ao "id" do banco de dados "USER"
	private User client;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "id.order")
	private Set<OrdemItem> items = new HashSet<>();
	
	@OneToOne(fetch = FetchType.EAGER,mappedBy = "order", cascade = CascadeType.ALL) //cascade é para mapear o mesmo id no payment e order
	private Payment payment;
	
	public Order () {
		
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public User getClient() {
		return client;
	}
	
	public Set<OrdemItem> getItems(){
		return items;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
	}

	public void setClient(User client) {
		this.client = client;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	//get é porque o spring boot JPA só vai mostrar no JSON(Postman) se tiver o get
	public Double getTotal() {
		double sum = 0.0;
		for(OrdemItem x : items) {
			sum += x.getSubTotal();	
		}
		return sum;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}
