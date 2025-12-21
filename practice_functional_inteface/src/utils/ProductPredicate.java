package utils;

import java.util.function.Predicate;

import entities.Product;

/*
 * Aqui é implementado o teste da Classe que está como predicado, no caso o teste para Product
 */
public class ProductPredicate implements Predicate<Product>{

	@Override
	public boolean test(Product p) {
		return p.getPrice() >= 100.0D;
	}
	
}
