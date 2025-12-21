package Entities;

public class Product  implements Comparable<Product> {
	private String name;
	private Double price; //Double used for study.
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	//the inteface Comparable request an implementation of compareTo method...
	//in this case the property name was used for test.
	@Override
	public int compareTo(Product o) {
		return this.name.toUpperCase().compareTo(o.getName().toUpperCase());
	}
	
}
