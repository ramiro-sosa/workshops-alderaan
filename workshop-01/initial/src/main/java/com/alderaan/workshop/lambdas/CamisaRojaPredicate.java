package com.alderaan.workshop.lambdas;

public class CamisaRojaPredicate implements CamisaPredicate {

	@Override
	public boolean test(Camisa camisa) {
		return "ROJA".equals(camisa.getTalle());
	}

}
