package com.alderaan.workshop.lambdas;

import java.util.List;
import java.util.function.Predicate;

public class Inventario {
	public List<Camisa> filtrarRojas(List<Camisa> camisas) { throw new UnsupportedOperationException(); }
	
	public List<Camisa> filtrar(List<Camisa> camisas, String color) {
		throw new UnsupportedOperationException();
	}

	public List<Camisa> filtrar(List<Camisa> camisas, String color, String talle, boolean flag) {
		throw new UnsupportedOperationException();
	}
	
	public List<Camisa> filtrar(List<Camisa> camisas, CamisaPredicate predicado) {
		throw new UnsupportedOperationException();
	}
	
	public List<Camisa> filtrar(List<Camisa> camisas, Predicate<String> predicado) {
		throw new UnsupportedOperationException();
	}

	public List<Camisa> filtrarLE(List<Camisa> camisas, Predicate<Camisa> predicado) {
		throw new UnsupportedOperationException();
	}
	
}
