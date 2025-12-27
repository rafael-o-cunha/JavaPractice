package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   Explicação da annotation @service está na classe TaxService
 * 
 *   Vale observa que quando os nomes são claros e diretos e passam pelo construtor, o 
 * framework irá reconhecer e irá realizar a instância e injeção automaticamente.
 */


@Service
public class PayService {
	
	@Autowired
	TaxService taxService;
	
	@Autowired
	private DeliverService deliverService;
	
	/*
	 *  Com o autowired o construtor pode ser omitido, bastando anotar
	 *  os atributos que o construtor receberia por parâmetro
	 * 
	public PayService(TaxService taxService, DeliverService deliverService) {
		this.taxService = taxService;
		this.deliverService = deliverService;
	}
	*/
	
	public double finalPrice(double cost, String state) {
		return cost + deliverService.fee(state) + taxService.tax(cost);
	}
	
}
