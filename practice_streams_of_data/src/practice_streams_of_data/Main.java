package practice_streams_of_data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		//stream_example();
		pipeline_example();

	}

	public static void stream_example() {

		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		Stream<Integer> st1 = list.stream();
		System.out.println(Arrays.toString(st1.toArray()));

		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));

		//Define elemento inicial e a l[ogica de geração dos próximos elementos.
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));

		/*
		 * 
		 * Fibonacci
		 * 
		 * primeiro elemento é um array de longs (par)
		 * 
		 * a função de geração leva a um novo de array de elementos contendo a logica de
		 * elementos dos pares
		 * 
		 * o map finaliza devolvendo apenas uma das posições.
		 * 
		 */
		Stream<Long> st4 = Stream.iterate(new long[] { 0L, 1L }, p -> new long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(10).toArray()));

	}

	public static void pipeline_example() {

		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));

		/*
		 * 
		 * Pega o primeiro elemento (neutro)
		 * 
		 * define uma função que irá atuar nos elementos do stream
		 * 
		 * neste caso o stream irá reduzir a lista de números em um total.
		 * 
		 */
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum = " + sum);

		List<Integer> newList = list.stream()
				.filter(x -> x % 2 == 0) // Predicate
				.map(x -> x * 10) // Function
				.collect(Collectors.toList()); // Collector

		System.out.println(Arrays.toString(newList.toArray()));

	}

}
