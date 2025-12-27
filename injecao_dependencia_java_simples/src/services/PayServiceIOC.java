package services;

import services.interfaces.DeductionService;

public class PayServiceIOC {

	/*
	 *   Injeção de dependência por inversão de controle
	 *   
	 *   Neste caso a dependência será injetada através do construtor, e o payService não connhece mais diretamente
	 * a implementação de deductionService.
	 * 
	 *   O programa principal realizará o setup desta dependência.
	 */
	private DeductionService deductionService;
	
	public PayServiceIOC(DeductionService ds) {
		this.deductionService = ds;
	}
	
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.20;
	}
}
