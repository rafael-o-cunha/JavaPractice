package practice_java_streams_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Entities.Account;
import Entities.Car;
import Entities.Product;
import util.MyComparator;
/**
 * 1 - realizando sort implementando Comparable na classe Product e criando critério na classe
 * 2 - realizando sort através de outra classe, uma Comparator pois implementa Comparator para ordenar Car.
 * 3 - realizando sort criando class anônima implementando o Comparator diretamente no método principal
 * 4 - realizando sort através de implementação de função lambda, que simplifica o uso no lugar da classe anônima.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("\n-[01]---------------\n");
		/*
		 * Using Comparable
		 */
		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		
		//the class need to be implementation of Interface Comparable
		//using the default implemented method compareTo...
		Collections.sort(products);
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("\n-[02]---------------\n");
		
		
		
		/*
		 * Using Default method Sort with Comparator 
		 */
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Uno", 22000.00));
		cars.add(new Car("Sandero", 45000.00));
		cars.add(new Car("Corolla", 90000.00));
		
		//Class MyComparator was used and this class implements Comparator interface.
		cars.sort(new MyComparator());
		for(Car c : cars) {
			System.out.println(c);
		}
		System.out.println("\n-[03]---------------\n");
		
		
		
		/*
		 * using Anonymous class implementing Comparator
		 */
		List<Account> cc = new ArrayList<>();
		cc.add(new Account(1102L, 22000.00));
		cc.add(new Account(1100L, 45000.00));
		cc.add(new Account(1101L, 90000.00));
		
		//anonymous class
		Comparator<Account> compNumber = new Comparator<Account>() {
			@Override
			public int compare(Account cc1, Account cc2) {
				return cc1.getNumber().compareTo(cc2.getNumber());
			}
		};
		
		cc.sort(compNumber);
		for(Account c : cc) {
			System.out.println(c);
		}
		
		System.out.println("\n-[04]---------------\n");
		
		
		/*
		 * using lambda Function to simplfy the implementation
		 */
		
		//lambda function or arrow function
		Comparator<Account> compNumberAndBalance = (cc1, cc2) -> {
		    int byNumber = cc1.getNumber().compareTo(cc2.getNumber());
		    if (byNumber != 0) {
		    	return byNumber;
		    }

		    return cc1.getBalance().compareTo(cc2.getBalance());
		};
		
		cc.sort(compNumberAndBalance);
		for(Account c : cc) {
			System.out.println(c);
		}
		
		System.out.println("----------------");
		
		
		//lambda function or arrow function short syntax
		Comparator<Account> compBalance = (cc1, cc2) -> cc1.getBalance().compareTo(cc2.getBalance());
	
		cc.sort(compBalance);
		for(Account c : cc) {
			System.out.println(c);
		}
		
		System.out.println("----------------");
		
		
		//more simple:
		cc.sort((cc1, cc2) -> cc1.getBalance().compareTo(cc2.getBalance()));
		for(Account c : cc) {
			System.out.println(c);
		}
		
		
		System.out.println("----------------");
		
	}

}
