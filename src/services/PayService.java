package services;

import services.interfaces.DeductionService;

public class PayService {

	/*
	 *   Injeção de dependência por atribuição direta.
	 * Alto acomplamento
	 * upcasting implícito
	 * 
	 *   O método de cronstrução aplicado funciona porém se o sistema precisar realizar
	 * cálculo a partir de outro estado (trocar MG por RJ), deverá haver uma alteração na classe payService
	 * e em muitos casos isso não é desejável.
	 * 
	 *   A próxima forma de implementar está na classe payServiceByIOC, onde o controle de instância da dependência
	 * não pertencerá ao payService
	 * 
	 *   o upcasting implícito através da classe contreta MGdeductionService subindo para a interface DeductionService
	 * permite trocar a implementação contreta por outra enquanto elas respeitarem o contrato(interface), realizando
	 * assim programação orientada a interface
	 */
	private DeductionService deductionService = new MGdeductionService();
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.20;
	}
}
