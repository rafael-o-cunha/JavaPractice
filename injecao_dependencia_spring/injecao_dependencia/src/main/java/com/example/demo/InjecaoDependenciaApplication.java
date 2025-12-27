package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.services.PayService;


/**
 *      Foi adicionado o CommandlineRunner para que seja possível(mesmo
 *   com o springboot) executar o programa principal trabalhando com o 
 *   console como uma aplicação java simples.
 *   
 *   No sprint há duas formas simples de fazer a injeção.
 *   	-> com o construtor na classe, ele irá reconhecer e irá realizar a instância.
 *   	-> com a annotation @autowired.
 *   
 *   se o atributo é declarado, é anotado como Component/Service, e é anotado com autowired, automaticamente o springboot identifica que poderá ser injetado e resolve.
 * 
 *   O framework faz reúso de instância para otimização de memória através do padrão de projeto singleton, ou seja,
 *  quando um objeto é anotado em uma classe como autowired mas também é anotado em outra classe, ele identificará que poderá usar o mesmo
 *  objeto instanciado.
 */


@SpringBootApplication
public class InjecaoDependenciaApplication implements CommandLineRunner{

	@Autowired
	private PayService payService;
	
	public static void main(String[] args) {
		SpringApplication.run(InjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("RESULTADO = " + payService.finalPrice(300.0, "SC"));
		
	}

}
