package com.appFrutaria.model;

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
	
	public String toString() {
		return ("\n+----------------------------------------+"
			  + "\n| * Nome da verdura: " + nome
			  + "\n| * Preço da verdura: " + preco
			  + "\n| * Quantidade de verduras: " + quantidade
			  + "\n| * Tipo da verdura: " + tipo
			  + "\n+----------------------------------------+");
	}

}
