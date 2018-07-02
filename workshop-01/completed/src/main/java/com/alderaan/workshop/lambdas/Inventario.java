package com.alderaan.workshop.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Inventario {
	
	public List<Camisa> filtrarRojas(List<Camisa> camisas) {
		List<Camisa> result = new ArrayList<>();
		
		for(Camisa c: camisas) {
			if( "ROJO".equals(c.getColor())) {
				result.add(c);
			}
		}
		return result;
	}
	
	public List<Camisa> filtrar(List<Camisa> camisas, String color) {
		List<Camisa> result = new ArrayList<>();
		
		for(Camisa c: camisas) {
			if( color.equals(c.getColor())) {
				result.add(c);
			}
		}
		return result;
	}

	public List<Camisa> filtrar(List<Camisa> camisas, String color, String talle, boolean flag) {
		List<Camisa> result = new ArrayList<>();
		
		for(Camisa c: camisas) {
			if((flag && color.equals(c.getColor())) || (!flag && talle.equals(c.getTalle()))) {
				result.add(c);
			}
		}
		return result;
	}
	
	public List<Camisa> filtrar(List<Camisa> camisas, CamisaPredicate predicado) {
		List<Camisa> result = new ArrayList<>();
		
		for(Camisa c: camisas) {
			if(predicado.test(c)) {
				result.add(c);
			}
		}
		return result;
	}
	
	public List<Camisa> filtrar(List<Camisa> camisas, Predicate<String> predicado) {
		List<Camisa> result = new ArrayList<>();
		
		for(Camisa c: camisas) {
			if(predicado.test(c.getColor())) {
				result.add(c);
			}
		}
		return result;
	}

	public List<Camisa> filtrarLE(List<Camisa> camisas, Predicate<Camisa> predicado) {
		List<Camisa> result = new ArrayList<>();
		
		for(Camisa c: camisas) {
			if(predicado.test(c)) {
				result.add(c);
			}
		}
		return result;
	}
}
