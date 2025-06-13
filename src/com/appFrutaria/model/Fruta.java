package com.appFrutaria.model;

// Aqui são as classes representantes dos atributos (dados)
// Elas servem APENAS para ser algo, e não farão nenhum subprocesso ou interação
public class Fruta {
	
	private String nome;
	private double preco;
	private int quantidade;
	
	public Fruta(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Fruta() {
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
	
}