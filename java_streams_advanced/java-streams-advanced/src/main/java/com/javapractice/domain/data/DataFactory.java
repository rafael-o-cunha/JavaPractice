package com.javapractice.domain.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

import com.javapractice.domain.City;
import com.javapractice.domain.Customer;
import com.javapractice.domain.Order;
import com.javapractice.domain.Product;
import com.javapractice.domain.State;
import com.javapractice.domain.types.CustomerType;
import com.javapractice.domain.types.RegionType;
import com.javapractice.domain.Category;
import com.javapractice.domain.OrderItem;
import com.javapractice.domain.types.PaymentMethodType;
import com.javapractice.domain.types.PaymentStatusType;
import com.javapractice.domain.types.OrderStatusType;
import com.javapractice.domain.Payment;

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
		State sp = new State("SP", "São Paulo", RegionType.SUDESTE);
		State rj = new State("RJ", "Rio de Janeiro", RegionType.SUDESTE);
		
		City saoPaulo = new City(1L, "São Paulo", sp);
		City rio = new City(2L, "Rio de Janeiro", rj);
		
		return List.of(
				new Customer(1L, "Ana", "ana@email.com", LocalDate.of(1990, 1, 10), CustomerType.PF, saoPaulo, LocalDate.now()),
				new Customer(2L, "Bruno", "bruno@email.com", LocalDate.of(1985, 5, 20), CustomerType.PJ, rio, LocalDate.now()),
				new Customer(3L, "Carla", "carla@email.com", LocalDate.of(1995, 3, 5), CustomerType.PF, rio, LocalDate.now())
				);
	}
	
	private List<Product> createProducts() {
		Category tech = new Category(1L, "Tecnologia", null);
		Category phone = new Category(2L, "Celulares", tech);
		Category laptop = new Category(3L, "Notebooks", tech);
		
		return List.of(
				new Product(1L, "Iphone", phone, new BigDecimal("6000"), true),
				new Product(2L, "Galaxy", phone, new BigDecimal("4500"), true),
				new Product(3L, "MacBook",laptop, new BigDecimal("12000"), true),
				new Product(4L, "Notebook Dell", laptop, new BigDecimal("8000"), true)
				);
	}
	
	private List<Order> createOrders() {
		Customer ana = this.customers.get(0);
		Customer bruno = this.customers.get(1);

		Product iphone = this.products.get(0);
		Product macBook = this.products.get(2);
		
		OrderItem item1 = new OrderItem(iphone, 1, iphone.getPrice());
		OrderItem item2 = new OrderItem(macBook, 1, macBook.getPrice());
		
		return List.of(
				new Order(1L,
						  ana,
						  LocalDateTime.now().minusDays(10),
						  OrderStatusType.PAID,
						  List.of(item1),
						  new Payment(PaymentMethodType.PIX, PaymentStatusType.PAID, iphone.getPrice(), LocalDateTime.now().minusDays(9)) ),
				new Order(2L,
						  bruno,
						  LocalDateTime.now().minusDays(5),
						  OrderStatusType.PAID,
						  List.of(item2),
						  new Payment(PaymentMethodType.CREDIT_CARD, PaymentStatusType.PAID, macBook.getPrice(), LocalDateTime.now().minusDays(4)) )
				);
	}
	
}
