package com.javapractice.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
	private Long id;
	private String name;
	private Category category;
	private BigDecimal price;
	private boolean active;
	
	public Product(Long id, String name, Category category, BigDecimal price, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.active = active;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, category, id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return active == other.active && Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", active="
				+ active + "]";
	}
	
}
