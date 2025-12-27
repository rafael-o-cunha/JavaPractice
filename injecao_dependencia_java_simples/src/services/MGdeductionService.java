package services;

import services.interfaces.DeductionService;

public class MGdeductionService implements DeductionService{

	@Override
	public double deduction(double amount) {
		return amount * 0.12;
	}

}
