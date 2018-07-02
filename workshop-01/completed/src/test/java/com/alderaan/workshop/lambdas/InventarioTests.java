package com.alderaan.workshop.lambdas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.alderaan.workshop.lambdas.Camisa;
import com.alderaan.workshop.lambdas.CamisaRojaPredicate;
import com.alderaan.workshop.lambdas.CamisaTalleXLPredicate;
import com.alderaan.workshop.lambdas.Inventario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventarioTests {
	
	List<Camisa> camisas = new ArrayList<>();
	Inventario inventario = new Inventario();
	
	@Before
	public void setUp() {
		camisas.add(new Camisa("ROJO", "M"));
		camisas.add(new Camisa("VERDE", "S"));
		camisas.add(new Camisa("ROJO", "XL"));
		camisas.add(new Camisa("AZUL", "L"));
	}
	
	@Test
	public void test01filtrarPorColorROJO() {
		//Given
		List<Camisa> expectedResult = Arrays.asList(new Camisa("ROJO", "M"), new Camisa("ROJO", "XL"));
		
		//When
		List<Camisa> result = inventario.filtrarRojas(camisas);

		//Then
		assertArrayEquals(expectedResult.toArray(),result.toArray());
	}
	
	@Test
	public void test02FiltrarPorColor( ) {
		//Given
		List<Camisa> expectedResult1 = Arrays.asList(new Camisa("ROJO", "M"), new Camisa("ROJO", "XL"));
		List<Camisa> expectedResult2 = Arrays.asList(new Camisa("VERDE", "S"));
		
		//When
		List<Camisa> result1 = inventario.filtrar(camisas, "ROJO");
		List<Camisa> result2 = inventario.filtrar(camisas, "VERDE");

		//Then
		assertArrayEquals(expectedResult1.toArray(),result1.toArray());
		assertArrayEquals(expectedResult2.toArray(),result2.toArray());
	}
	
	@Test
	public void test03FiltrarPorColorYTalle( ) {
		//Given
		List<Camisa> expectedResult1 = Arrays.asList(new Camisa("ROJO", "M"), new Camisa("ROJO", "XL"));
		List<Camisa> expectedResult2 = Arrays.asList(new Camisa("AZUL", "L"));
		
		//When
		List<Camisa> result1 = inventario.filtrar(camisas, "ROJO", "M", true);
		List<Camisa> result2 = inventario.filtrar(camisas, "ROJO", "L", false);

		//Then
		assertArrayEquals(expectedResult1.toArray(),result1.toArray());
		assertArrayEquals(expectedResult2.toArray(),result2.toArray());
	}
	
	@Test
	public void test04FiltrarConEstrategia( ) {
		//Given
		List<Camisa> expectedResult1 = Arrays.asList(new Camisa("ROJO", "M"), new Camisa("ROJO", "XL"));
		List<Camisa> expectedResult2 = Arrays.asList(new Camisa("ROJO", "XL"));
		
		CamisaRojaPredicate rojas = new CamisaRojaPredicate();
		CamisaTalleXLPredicate talleXL = new CamisaTalleXLPredicate();
		
		//When
		List<Camisa> result1 = inventario.filtrar(camisas, rojas);
		List<Camisa> result2 = inventario.filtrar(camisas, talleXL);

		//Then
		assertArrayEquals(expectedResult1.toArray(),result1.toArray());
		assertArrayEquals(expectedResult2.toArray(),result2.toArray());
	}
	
	@Test
	public void test05FiltrarConLambdaExpressions( ) {
		//Given
		List<Camisa> expectedResult1 = Arrays.asList(new Camisa("ROJO", "M"), new Camisa("ROJO", "XL"));
		List<Camisa> expectedResult2 = Arrays.asList(new Camisa("ROJO", "XL"));
		
		Predicate<String> p = s -> "ROJO".equals(s);
		
		//When
		List<Camisa> result1 = inventario.filtrar(camisas, p);
		List<Camisa> result2 = inventario.filtrarLE(camisas, c -> "ROJO".equals(c.getColor()));
		List<Camisa> result3 = inventario.filtrarLE(camisas, c -> "XL".equals(c.getTalle()));

		//Then
		assertArrayEquals(expectedResult1.toArray(),result1.toArray());
		assertArrayEquals(expectedResult1.toArray(),result2.toArray());
		assertArrayEquals(expectedResult2.toArray(),result3.toArray());
	}
}
