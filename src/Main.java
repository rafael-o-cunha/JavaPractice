import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import models.DoublyLinkedList;
import models.List;
import models.MyQueue;
import models.MyStack;
import models.Produto;
import models.Triangle;

public class Main {
	
	public static void useList()
	{
		List<String> lst = new List<>();
		
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		
		System.out.println(lst.get(0));
		System.out.println(lst.get(2));
		System.out.println(lst.toString());
		System.out.println("--------------------------");
		System.out.println(lst.isEmpty());
		System.out.println(lst.size());
		System.out.println("--------------------------");
		lst.removeById(2);
		System.out.println(lst.size());
		System.out.println(lst.toString());
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		//https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		LinkedList<String> java_lst = new LinkedList<>();
		
		java_lst.add("1");
		java_lst.add("2");
		java_lst.add("3");
		java_lst.add("4");
		
		System.out.println(java_lst.get(0));
		System.out.println(java_lst.get(2));
		System.out.println(java_lst.toString());
		System.out.println("--------------------------");
		System.out.println(java_lst.isEmpty());
		System.out.println(java_lst.size());
		System.out.println("--------------------------");
		java_lst.remove(2);
		System.out.println(java_lst.size());
		System.out.println(java_lst.toString());
		
		System.out.println("");
		System.out.println("");
		
		ArrayList<String> list_txt = new ArrayList<>();

		list_txt.add("Zequinha");
		list_txt.add("Toinho");
		list_txt.add("Milzinhu");
		list_txt.add("Nininhu");
		
		for(String name : list_txt)
		{
			System.out.println(name);
		}
		System.out.println("");
		
		list_txt.remove(2);
		list_txt.remove("Toinho");
		list_txt.add(2, "Lilinho");
		
		for(String name : list_txt)
		{
			System.out.println(name);
		}
		System.out.println("");
		
		//usando predicado para remoção e este é criado através de uma expressão lambda
		list_txt.removeIf(x -> x.charAt(0) == 'L');

		list_txt.add("Toinho");
		list_txt.add("Milzinhu");

		//usando stram para filtrar a lista
		//nao funcioa, estudarei mais arte
		/*
		 
		List<String> result = (List<String>) list_txt
				.stream()
	            .filter(x -> x.charAt(1) == 'i')
	            .map(String::valueOf) // Converte os caracteres em strings
	            .collect(Collectors.toList());
		
		
		//não sei como imprimir ainda, o modo padrão  da erro
		 for (int i = 0; i < result.size(); i++) {
	            String elemento = result.get(i);
	            System.out.println(elemento);
	        }
		System.out.println("");
		
		*/
		
		//usando  stream, filter, lambda, para busca de um dado
		String gato = list_txt.stream().filter(x -> x.charAt(0) == 'M').findFirst().orElse(null);
		System.out.println(gato);
		System.out.println("");
	}

	public static void useDoublyList()
	{
		DoublyLinkedList<String> dLst  = new DoublyLinkedList<>();
		
		dLst.add("1");
		dLst.add("2");
		dLst.add("3");
		dLst.add("4");
		dLst.add("5");
		
		System.out.println(dLst.get(0));
		System.out.println(dLst.get(2));
		System.out.println(dLst.toString());
		System.out.println("--------------------------");
		System.out.println(dLst.isEmpty());
		System.out.println(dLst.size());
		System.out.println("--------------------------");
		dLst.removeById(2);
		System.out.println(dLst.size());
		System.out.println(dLst.toString());
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		//https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		
		//segundo a documentação o java não possui implementação padrão para lista duplamente ligada
		//depois vou pesquisar e ver o que há disponível.
		
	}

	public static void useStack() {
		MyStack<String> stk = new MyStack<>();
	
		stk.push("e");
		stk.push("d");
		stk.push("c");
		stk.push("b");
		stk.push("a");
		
		System.out.println(stk.peek());
		System.out.println(stk.toString());
		System.out.println("--------------------------");
		System.out.println(stk.isEmpty());
		System.out.println(stk.size());
		System.out.println("--------------------------");
		stk.pop();
		System.out.println(stk.isEmpty());
		System.out.println(stk.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(stk.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
		
		
		
		
		//Stack está em java.util.stack
		//https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
		Stack<String> Stk = new Stack<>();
		
		Stk.push("e");
		Stk.push("d");
		Stk.push("c");
		Stk.push("b");
		Stk.push("a");
		
		System.out.println(Stk.peek());
		System.out.println(Stk.toString());
		System.out.println("--------------------------");
		System.out.println(Stk.isEmpty());
		System.out.println(Stk.size());
		System.out.println("--------------------------");
		Stk.pop();
		System.out.println(Stk.isEmpty());
		System.out.println(Stk.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(Stk.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
		
	}
	
	public static void useQueue() {
		MyQueue<String> que = new MyQueue<>();
		
		que.enqueue("a");
		que.enqueue("b");
		que.enqueue("c");
		que.enqueue("d");
		que.enqueue("e");
		
		System.out.println(que.get());
		System.out.println(que.toString());
		System.out.println("--------------------------");
		System.out.println(que.isEmpty());
		System.out.println(que.size());
		System.out.println("--------------------------");
		que.dequeue();
		System.out.println(que.isEmpty());
		System.out.println(que.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(que.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
		
		
		Queue<String> Que = new LinkedList<>();
		
		Que.add("a");
		Que.add("b");
		Que.add("c");
		Que.add("d");
		Que.add("e");
		
		System.out.println(Que.peek()); //peek retorna sem remover
		System.out.println(Que.toString());
		System.out.println("--------------------------");
		System.out.println(Que.isEmpty());
		System.out.println(Que.size());
		System.out.println("--------------------------");
		Que.poll(); //retorna removendo
		System.out.println(Que.isEmpty());
		System.out.println(Que.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(Que.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
	}
	
	public static void useStringFunctions()
	{
		String a = "  O JOVEM NO BRASIL NÃO É LEVADO A SÉRIO.  ";
		
		System.out.println("|" + a.toLowerCase() + "|");
		System.out.println("|" + a.toUpperCase() + "|");
		System.out.println();
				
		System.out.println("|" + a.trim() + "|");
		System.out.println();
		
		System.out.println("|" + a.substring(10) + "|");
		System.out.println("|" + a.substring(10, 19) + "|");
		System.out.println();
		
		System.out.println("|" + a.replace('.', ';')+ "|");
		System.out.println("|" + a.replace("É", "EH")+ "|");
		System.out.println();
		
		System.out.println("|" + a.indexOf('R') + "|");
		System.out.println("|" + a.lastIndexOf('R') + "|");
		System.out.println();
		
		String[] vetorChars = a.trim().split(" ");
		
		System.out.println("|" + vetorChars[2] + "|");
		System.out.println("|" + vetorChars[3] + "|");
		System.out.println("|" + vetorChars[4] + "|");
		System.out.println("|" + vetorChars[5] + "|");
		System.out.println();
		
		for(int i = 0; i < vetorChars.length; i++) {
			System.out.println(vetorChars[i]);
		}
		System.out.println();
		
		for(int i = 0; i < a.length(); i++) {
			System.out.println(a.charAt(i));
			
			if (a.charAt(i) == 'A')
					break ;
		}
		System.out.println();
		
		String 	b = String.copyValueOf(a.toCharArray());
				b = new String(a);
		
		System.out.println(b);
		System.out.println();
		
		System.out.println(b.contains("BRA"));
		System.out.println(b.contains("bra"));
		System.out.println();
		
		a = "42";
		
		int x = Integer.parseInt(a);
		System.out.println(x);
		System.out.println();
		
		String y = Integer.toString(x);
		System.out.println(y);
		System.out.println();
	}
	
	public static void useScanner()
	{
		//troca o uso da (,) por (.) por conta do idioma do s.o.
		Locale.setDefault(new Locale("en", "US"));
		
		Scanner sc = new Scanner(System.in);
		
		int 	a;
		double 	b;
		String 	str;
		
		a = sc.nextInt();
		b = sc.nextDouble();
		str = sc.next();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(str);
		
		sc.close();
	}
	
	public static void useTriangle() {
		Scanner sc2 = new Scanner(System.in);
		
		Triangle x = new Triangle();
		Triangle y = new Triangle();
		
		System.out.println("entre com lados do triangulo x: ");
		x.setA(sc2.nextDouble());
		x.setB(sc2.nextDouble());
		x.setC(sc2.nextDouble());
		
		System.out.println("entre com lados do triangulo y: ");
		y.setA(sc2.nextDouble());
		y.setB(sc2.nextDouble());
		y.setC(sc2.nextDouble());
		
		sc2.close();
		
		System.out.println();
		System.out.println("os lados do triângulo X são: " 
				+ x.getA()  + " " + x.getB()  + " " + x.getC()  + " ");
		System.out.println("A área do triângulo X é: " + x.getArea());
		
		System.out.println();
		System.out.println("os lados do triângulo Y são: " 
				+ y.getA()  + " " + y.getB()  + " " + y.getC()  + " ");
		System.out.println("A área do triângulo Y é: " + y.getArea());
		
		
		
	}
	
	public static void useProduto() {
		Scanner sc = new Scanner(System.in);
		
		Produto p1 = new Produto();
		
		System.out.print("entre com o nome do produto:  ");
		p1.setNome(sc.nextLine());
		
		System.out.print("entre com o preço do produto:  ");
		p1.setPreco(sc.nextDouble());
		
		System.out.print("entre com a quantidade do produto:  ");
		int quantidade = sc.nextInt();
		p1.adicionarProdutos(quantidade);
		
		System.out.println(p1.toString());
		
		p1.removerProdutos(1);
		System.out.println(p1.toString());
		
		sc.close();
	}
	
	public static void useMatrix() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[n][n];
		int count_neg = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] < 0)
					count_neg++;
			}
		}
		
		sc.close();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("[" + matrix[i][j] + "]");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("quantidade de negativos: " + count_neg);
		System.out.println();
		
		System.out.println("Diagonal principal: ");
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j)
					System.out.print("[" + matrix[i][j] + "]");
			}
		}
		System.out.println();

	}
	
	public static void main(String[] args) {

		//useList();
		//useDoublyList();
		//useStack();
		//useQueue();
		//useStringFunctions();
		//useScanner();
		//useTriangle();
		//useProduto();
		//useMatrix();
		
	}
}
