package com.appFrutaria.model;

// Aqui são as classes representantes dos atributos (dados)
// Elas servem APENAS para ser algo, e não farão nenhum subprocesso ou interação
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
	
	public String toString() {
		return ("\nNome da fruta: " + nome
				+ "\nPreço da fruta: " + preco
				+ "\nQuantidade de frutas: " + quantidade
				+ "\nPeso da fruta: " + peso);
	}
	
}