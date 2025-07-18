package com.appFrutaria.model;

// Superclasse, a classe da qual o restante vai herdar
public class Produto {
	
	protected String nome;
	protected double preco;
	protected int quantidade;
	
	public Produto(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Produto() {
		this.nome = "";
		this.preco = 0.0;
		this.quantidade = 0;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	@Override
	public String toString() {
		return ("\nNome do produto: " + nome
				+ "\nPreço do produto: " + preco
				+ "\nQuantidade do produto: " + quantidade);
	}

}
