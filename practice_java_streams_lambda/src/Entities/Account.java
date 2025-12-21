package Entities;

public class Account {
	private Long number;
	private Double balance; //Double used for study.
	
	public Account(Long number, Double balance) {
		this.number = number;
		this.balance = balance;
	}

	public Long getNumber() {
		return number;
	}
	
	public void setNumber(Long number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}

}
