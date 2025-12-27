package com.example.demo.services;

import org.springframework.stereotype.Service;

/**
 *   A anotation @Component permite a classe ser gerenciada pelo framework
 *   dessa forma o framewor irá registrá-la automaticamente para que ela
 *   possa ser instanciada, injetada, utilizada.
 *   
 *   Tamém pode-se utilizar o @Service, ele executa a mesma coisa mas é semântico, ou seja,
 *   ele serve para registrar e o framework realizar o gerenciamento mas também serve de 
 *   leitura prática para o desenvolvedor, dado que esta classe é um service e está
 *   no pacote service.
 *   
 */


@Service
public class TaxService {

	public double tax(double value) {
		return value * 0.1;
	}
}
