package com.appFrutaria.model;

public class Verdura extends Produto {
	
	private String tipo;
	
	public Verdura(String nome, double preco, int quantidade, String tipo) {
		super();
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

}
