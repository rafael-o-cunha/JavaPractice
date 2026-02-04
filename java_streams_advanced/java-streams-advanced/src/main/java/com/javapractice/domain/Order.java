package com.javapractice.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.javapractice.domain.types.OrderStatusType;

public class Order {
	private Long id;
	private Customer customer;
	private LocalDateTime createdAt;
	private OrderStatusType status;
	private List<OrderItem> items;
	private Payment payment;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public OrderStatusType getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatusType status) {
		this.status = status;
	}
	
	public List<OrderItem> getItems() {
		return items;
	}
	
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, customer, id, items, payment, status);
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
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(customer, other.customer)
				&& Objects.equals(id, other.id) && Objects.equals(items, other.items)
				&& Objects.equals(payment, other.payment) && status == other.status;
	}
	
}
