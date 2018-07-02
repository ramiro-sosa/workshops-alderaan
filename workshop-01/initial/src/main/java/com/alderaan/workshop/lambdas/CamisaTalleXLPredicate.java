package com.alderaan.workshop.lambdas;

import com.alderaan.workshop.lambdas.Camisa;
import com.alderaan.workshop.lambdas.CamisaPredicate;

public class CamisaTalleXLPredicate implements CamisaPredicate {

	@Override
	public boolean test(Camisa camisa) {
		return "XL".equals(camisa.getTalle());
	}

}
