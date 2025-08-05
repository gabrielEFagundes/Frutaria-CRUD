package com.appFrutaria.model;

public class Fruta extends Produto {
	
	private double peso;
	
	public Fruta(String nome, double preco, int quantidade, double peso) {
		super(nome, preco, quantidade);
		this.peso = peso;
	}
	
	public Fruta() {
		super();
		this.peso = 0.0;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return String.format("| %-21s | %-15.2f | %-13d | %-13.2f |"
					       + "\n+-------------------------------------------------------------------------+", 
					       nome, preco, quantidade, peso);
	}
	
}