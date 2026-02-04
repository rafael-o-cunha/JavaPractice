package com.javapractice.domain.data;

import java.util.List;

import com.javapractice.domain.Customer;
import com.javapractice.domain.Order;
import com.javapractice.domain.Product;

public class DataFactory {
	private List<Customer> customers = null;
	private List<Product> products = null;
	private List<Order> orders = null;
	
	public DataFactory() {
		this.customers = this.createCustomers();
		this.products = this.createProducts();
		this.orders = this.createOrders();
	}
	
	public List<Customer> selectAllCustomers() {
		return this.customers;
	}
	
	public List<Product> selectAllProducts() {
		return this.products;
	}
	
	public List<Order> selectAllOrders() {
		return this.orders;
	}
	
	private List<Customer> createCustomers() {
		return null;
	}
	
	private List<Product> createProducts() {
		return null;
	}
	
	private List<Order> createOrders() {
		return null;
	}
	
}
