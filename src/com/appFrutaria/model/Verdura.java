package com.appFrutaria.model;

import com.appFrutaria.view.Atendente;

public class Verdura extends Produto {
	
	private String tipo;
	
	public Verdura(String nome, double preco, int quantidade, String tipo) {
		super(nome, preco, quantidade);
		this.tipo = tipo;
	}
	
	public Verdura() {
		super();
		this.tipo = "";
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	@Override
	public String toString() {
		return String.format("| %-21s | %-15.2f | %-13d | %-13s |"
			       + "\n+-------------------------------------------------------------------------+", 
			       nome, preco, quantidade, tipo);
	}

}
