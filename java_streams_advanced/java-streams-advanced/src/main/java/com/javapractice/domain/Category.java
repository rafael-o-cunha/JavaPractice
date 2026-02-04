package com.javapractice.domain;

import java.util.Objects;

public class Category {
	private Long id;
	private String name;
	private Category parent;
	
	public Category(Long id, String name, Category parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
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
	
	public Category getParent() {
		return parent;
	}
	
	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, parent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(parent, other.parent);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}
	
}
