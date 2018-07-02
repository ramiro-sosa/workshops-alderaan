package com.alderaan.workshop.lambdas;

import java.util.Objects;

public class Camisa {
	private String color;
	private String talle;

	public Camisa(String color, String talle) {
		this.color = color;
		this.talle = talle;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(color, talle);
	}
	
	@Override
	public boolean equals(Object c) {
		return (this.color.equals(((Camisa) c).getColor())) && (this.talle.equals(((Camisa) c).getTalle()));
	}
}
