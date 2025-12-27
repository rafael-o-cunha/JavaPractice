package injecao_dependencia;

import services.MGdeductionService;
import services.PayService;
import services.PayServiceIOC;
import services.interfaces.DeductionService;

public class Main {

	public static void main(String[] args) {
		/*
		 * Realizando cálculo de imposto 
		 * -> normal
		 * -> isolando em um service
		 * -> 
		 * 
		 * 
		 *   case: você tem uma quantidade de dinheiro e precisa saber a quantidade de
		 * imposto a pagar.
		 */
		
		//basicCalcExample();
		
		//basicServiceCalcExample();
		
		serviceCalcIOCExample();
	}

	private static void basicCalcExample() {
		System.out.println("\n\n|-----BASIC CALC EXAMPLE------------------------------------------|\n");
		double value = 1000.00;
		//MG (%)
		double deduction = 12.00;
		double tax = 20.00;
		
		double valueAfterDeduction = value  - (value * (deduction/100));
		
		double valueAfterTax = valueAfterDeduction  - (valueAfterDeduction * (tax/100));
		
		double taxValue = valueAfterDeduction - valueAfterTax;

		System.out.printf("value (R$):                %.2f \n", value);
		System.out.printf("deduction (%%):             %.2f \n", deduction);
		System.out.printf("valueAfterDeduction (R$):  %.2f \n", valueAfterDeduction);
		System.out.printf("Tax (%%):                   %.2f \n", tax);
		System.out.printf("valueAfterTax (R$):        %.2f \n", valueAfterTax);
		System.out.printf("taxValue (R$):             %.2f \n", taxValue);
	}
	
	private static void basicServiceCalcExample() {
		System.out.println("\n\n|-----BASIC SERVICE CALC EXAMPLE------------------------------------------|\n");
		double value = 1000.00;
		
		/*
		 * payService é responsável pela parte de pagamento e retorna quanto foi/será) pago
		 * payService conhece o serviço de deduções, não o programa principal.
		 */
		PayService payService = new PayService();
		double taxValue = payService.tax(value);

		System.out.printf("value (R$):                %.2f \n", value);
		System.out.printf("taxValue (R$):             %.2f \n", taxValue);
	}
	
	private static void serviceCalcIOCExample() {
		System.out.println("\n\n|-----BASIC SERVICE CALC EXAMPLE------------------------------------------|\n");
		double value = 1000.00;
		
		/*
		 *   PayService é responsável pela parte de pagamento e retorna quanto foi/será) pago
		 * 
		 *   Neste caso PayService não conhecerá qual implementação está sendo aplicada, pois ele precisa apenas
		 * consumir o resultado desse serviço através de seu contrato, ele não precisará conhecer a implementação.
		 * 
		 *    Caso seja necessário realizar alguma alteração, esta será realizada no programa principal.
		 * 
		 *    No PayServiceIOC foi realizado injeção de dependência via construtor.
		 * 
		 *    Outro ponto importante é que quando realiza este tipo de configuração de um serviço o ciclo de vida do objeto
		 * pode estar no programa principal e não na classe interna, neste caso a configuração de deduction estaria disponível
		 * para N contextos da aplicação enquanto ela estiver rodando, comparando com o outro tipo de configuração isso
		 * poderia não ocorrer pois, uma vez que um objeto não estando instanciado, não poderíamos acessar o outro, impedindo reúso
		 * simplificado do outro.
		 */
		PayServiceIOC payService = new PayServiceIOC(new MGdeductionService());
		double taxValue = payService.tax(value);

		System.out.printf("value (R$):                %.2f \n", value);
		System.out.printf("taxValue (R$):             %.2f \n", taxValue);
	}


}
