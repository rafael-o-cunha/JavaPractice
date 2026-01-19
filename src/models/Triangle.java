package models;

public class Triangle {
	private double a;
	private double b;
	private double c;
	
	public Triangle() {
		
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
	public double getArea() {
		return (this.a + this.b + this.c) / 2.0;
	}
}
