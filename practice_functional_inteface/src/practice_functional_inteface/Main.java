package practice_functional_inteface;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entities.Product;
import utils.PriceUpdate;
import utils.ProductPredicate;
import utils.UpperCaseName;

/**
 * 1 - Interface funcional -> interface que possui um único método abstrato e suas implementações serão
 * tratadas como expressões lambda.
 * Java precisa dessa regra para que saiba o que a lambda significa.
 * 
 * 	Interfaces funcionaiis comuns:
 * 		1 - Predicate: Representa uma função que recebe um valor e retorna um boolean.
 * 		2 - Function: Representa uma função que transforma algo em outra coisa.
 * 		3 - *Consumer(Pode gerar efeitos colaterais): Representa uma função que recebe um valor e não retorna nada (void).
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * 		1 - Predicate: Representa uma função que recebe um valor e retorna um boolean. -> geralmente utilizado para filtrar
		 * 			Implementações realizadas:
		 * 				1 - Implementação de interface.
		 * 				2 - Reference method com método estático.
		 * 				3 - Reference method com método não estático.
		 * 				4 - Expressão Lambda declarada.
		 * 				5 - Expressão Lambda inline.
		 */
		//practicePredicate();
		
		
		/**
		 * 		2 - Consumer: Representa uma função que modifica parte do elemento. -> geralmente utilizado para modificar
		 * 			Implementações realizadas:
		 * 				1 - Implementação de interface.
		 * 				2 - Reference method com método estático.
		 * 				3 - Reference method com método não estático.
		 * 				4 - Expressão Lambda declarada.
		 * 				5 - Expressão Lambda inline.
		 */
		//practiceConsumer();
		
		
		/**
		 * 		3 - Function: Representa uma função que transforma algo em outra coisa. -> geralmente utilizada para filtrar transformando ou apenas transformar
		 * 			Implementações realizadas:
		 * 				1 - Implementação de interface.
		 * 				2 - Reference method com método estático.
		 * 				3 - Reference method com método não estático.
		 * 				4 - Expressão Lambda declarada.
		 * 				5 - Expressão Lambda inline.
		 */
		practiceFunction();
		
	}
	
	private static void practicePredicate() {
		/**
		 * Praticando predicate
		 * -> a partir de uma lista de itens, remova da lista somente aqueles cujo preço mínimo seja 500.00
		 */
		
		System.out.println("\n-[01]--Padrão-------------\n");

		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		products.add(new Product("HD Case", 90.00));
		products.add(new Product("Mouse", 50.00));
		
		List<Product> items = deepCopyList(products);
		List<Product> items2 = deepCopyList(products);
		List<Product> items3 = deepCopyList(products);
		List<Product> items4 = deepCopyList(products);
		List<Product> items5 = deepCopyList(products);
		
		printListln(products);
		
		//usando o padrão conhecido
		products.removeIf(p -> p.getPrice() >= 100.0D);
		
		printListln(products);
		
		
		
		System.out.println("\n-[01.1]--Implementação de interface.-------------\n");
		
		printListln(items);
		
		//usando ProductPredicate, ou seja, personalizando o teste.
		// 1.1 Implementação de interface.
		items.removeIf(new ProductPredicate());
		
		printListln(items);
		
		
		
		System.out.println("\n-[01.2]--Reference method com método estático.-------------\n");
		
		printListln(items2);
		
		//foi implementado o método estático na classe Product
		// 1.2 - Reference method com método estático.
		items2.removeIf(Product::staticProductPredicate);
		
		printListln(items2);
		
		
		
		System.out.println("\n-[01.3]--Reference method com método não estático.-------------\n");
		
		printListln(items3);
		
		//foi implementado o método NÃO estático na classe Product.
		// 1.3 - Reference method com método não estático.
		items3.removeIf(Product::nonStaticProductPredicate);
		
		printListln(items3);
		
		
		
		System.out.println("\n-[01.4]--Expressão Lambda declarada.-------------\n");
		
		printListln(items4);
		
		Predicate<Product> pred = p -> p.getPrice() >= 100.0D; 
		
		items4.removeIf(pred);
		
		printListln(items4);
		
		
		
		System.out.println("\n-[01.5]- Expressão Lambda inline.-------------\n");
		
		printListln(items5);
		//inline
		items5.removeIf(p -> p.getPrice() >= 100.0D);
		
		printListln(items5);
		
	}

	
	private static void practiceConsumer() {
		/**
		 * Praticando consumer
		 * -> a partir de uma lista de itens, aumente o preço de produtos em 10%
		 */
		
		System.out.println("\n-[01]--Padrão-------------\n");

		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		products.add(new Product("HD Case", 90.00));
		products.add(new Product("Mouse", 50.00));
		
		List<Product> items = deepCopyList(products);
		List<Product> items2 = deepCopyList(products);
		List<Product> items3 = deepCopyList(products);
		List<Product> items4 = deepCopyList(products);
		List<Product> items5 = deepCopyList(products);
		
		
		System.out.println("\n-[01.1]--Implementação de interface.-------------\n");
		
		printListln(items);
		
		// 1.1 Implementação de interface.
		items.forEach(new PriceUpdate());
		
		printListln(items);
		
		
		
		System.out.println("\n-[01.2]--Reference method com método estático.-------------\n");
		
		printListln(items2);
		
		//foi implementado o método estático na classe Product
		// 1.2 - Reference method com método estático.
		items2.forEach(Product::staticPriceUpdate);
		
		printListln(items2);
		
		
		
		System.out.println("\n-[01.3]--Reference method com método não estático.-------------\n");
		
		printListln(items3);
		
		//foi implementado o método NÃO estático na classe Product.
		// 1.3 - Reference method com método não estático.
		items3.forEach(Product::nonStaticPriceUpdate);
		
		printListln(items3);
		
		
		
		System.out.println("\n-[01.4]--Expressão Lambda declarada.-------------\n");
		
		printListln(items4);
		
		Consumer<Product> con = p -> {
			p.setPrice(p.getPrice() * 1.1);
		}; 
		
		items4.forEach(con);
		
		printListln(items4);
		
		
		
		System.out.println("\n-[01.5]- Expressão Lambda inline.-------------\n");
		
		printListln(items5);
		//inline
		items5.forEach(p -> p.setPrice(p.getPrice() * 1.1));
		
		printListln(items5);
	}

	private static void practiceFunction() {
		/**
		 * Praticando consumer
		 * -> a partir de uma lista de itens(produtos), gere uma nova lista contendo os nomes em caixa alta 
		 */
		
		System.out.println("\n-[01]--Padrão-------------\n");

		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		products.add(new Product("HD Case", 90.00));
		products.add(new Product("Mouse", 50.00));
		
		List<Product> items = deepCopyList(products);
		List<Product> items2 = deepCopyList(products);
		List<Product> items3 = deepCopyList(products);
		List<Product> items4 = deepCopyList(products);
		List<Product> items5 = deepCopyList(products);
		
		
		System.out.println("\n-[01.1]--Implementação de interface.-------------\n");
		
		printListln(items);
		
		// 1.1 Implementação de interface.
		/**
		 * Aplicando o uso de Map (que aplica uma função em cada elemento de  um stream)
		 * -> trabalhar com fluxo de dados extraído da lista
		 * -> mapear cada opjeto para reduzir para String
		 * -> coletar cada item transformando novamente os dados em uma lista
		 */
		List<String> nomes = items.stream().map(new UpperCaseName()).collect(Collectors.toList());
		
		nomes.forEach(n -> System.out.println(n));
			
		
		
		
		System.out.println("\n-[01.2]--Reference method com método estático.-------------\n");
		
		printListln(items2);
		
		//foi implementado o método estático na classe Product
		// 1.2 - Reference method com método estático.
		List<String> nms = items2.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		
		nms.forEach(n -> System.out.println(n));
		
		
		
		System.out.println("\n-[01.3]--Reference method com método não estático.-------------\n");
		
		printListln(items3);
		
		//foi implementado o método NÃO estático na classe Product.
		// 1.3 - Reference method com método não estático.
		List<String> names = items2.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
		
		names.forEach(n -> System.out.println(n));
		
		
		
		
		System.out.println("\n-[01.4]--Expressão Lambda declarada.-------------\n");
		
		printListln(items4);
		
		Function<Product, String> func = p -> {
			return p.getName().toUpperCase();
		}; 
		
		List<String> nams = items2.stream().map(func).collect(Collectors.toList());
		
		nams.forEach(n -> System.out.println(n));
		
		
		
		System.out.println("\n-[01.5]- Expressão Lambda inline.-------------\n");
		
		printListln(items5);
		//inline
		List<String> nmes = items2.stream().map(p-> p.getName().toUpperCase()).collect(Collectors.toList());
		
		nmes.forEach(n -> System.out.println(n));
		
		
	}
	
	public static void printListln(List<Product> items) {
		items.forEach(p -> System.out.println(p));
		System.out.println();
	}

	public static List<Product> deepCopyList(List<Product> list) {
	    return list.stream()
	               .map(Product::new)
	               .toList();
	}
}
