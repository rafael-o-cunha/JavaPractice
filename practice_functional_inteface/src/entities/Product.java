package entities;

public class Product {
	private String name;
	private Double price; //Double used for study.
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	//construtor de cópia
	public Product(Product p) {
        this.name = p.name;
        this.price = p.price;
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
	
	//1.2
	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100.0D;
	}
	
	//1.3
	public boolean nonStaticProductPredicate() {
		return this.getPrice() >= 100.0D;
	}
	
	//1.2
	public static void staticPriceUpdate(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}
	
	//1.3
	public void nonStaticPriceUpdate() {
		this.setPrice(this.getPrice() * 1.1);
	}
	
	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}
	
	public String nonStaticUpperCaseName() {
		return this.getName().toUpperCase();
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
