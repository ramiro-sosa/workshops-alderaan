package com.alderaan.workshop.lambdas;

public class CamisaRojaPredicate implements CamisaPredicate {

	@Override
	public boolean test(Camisa camisa) {
		return "ROJO".equals(camisa.getColor());
	}

}
