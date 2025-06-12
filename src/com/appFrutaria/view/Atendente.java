package com.appFrutaria.view;

import java.util.List;
import java.util.Scanner;

import com.appFrutaria.model.Fruta;

// Aqui é a interação com o usuário
public class Atendente {

	Scanner scan;
	
	public Atendente() {
		scan = new Scanner(System.in);
		
	}
	
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	public Scanner getScan() {
		return scan;
	}
	
	
	public int menuPrincipal() {
		
		System.out.println("\n--- Frutaria Fagundes ---");
		System.out.printf("\n1- Cadastrar produto"
				+ "\n2- Listar produtos"
				+ "\n3- Remover produtos"
				+ "\n0- Sair"
				+ "\n-------------------------"
				+ "\nSua escolha: ");
		
		int escolhaMenu = scan.nextInt();
		
		// Retorna o valor lá para a Main
		return escolhaMenu;
		
	}
	
	
	public String definirNome() {
		
		System.out.println("\nDefina o nome da fruta: ");
		String nomeFruta = scan.next();
		
		return nomeFruta;
	}
	
	
	public double definirPreco() {
		
		System.out.println("\nDefina o preço da fruta: ");
		double precoFruta = scan.nextDouble();
		
		return precoFruta;
	}
	
	
	public int definirEstoque() {
		
		System.out.println("\nDefina o estoque da fruta: ");
		int estoqueFruta = scan.nextInt();
		
		return estoqueFruta;
	}
	
	
	public void listarFrutas(List<Fruta> estoqueFrutas) {
		
		System.out.println("");
		
		for(Fruta i : estoqueFrutas) {
			System.out.println("Nome: " + i.getNome() + " | Preço: " + i.getPreco() + " | Quantidade: " + i.getQuantidade());
		}
	}
	
	
	public int removerFrutas(List<Fruta> estoqueFruta) {
		
		int cont = 1; // Serve apenas para mostrar um índice mais "amigável"
		System.out.println("");
		
		for(Fruta i : estoqueFruta) {
			System.out.println(cont + "- " + i.getNome());
			cont++;
		}
		
		System.out.println("\nDigite o índice da fruta para remover: ");
		int nomeRemove = scan.nextInt();
		
		nomeRemove -= 1; // Para que o índice que aparece se iguale ao índice da lista
		
		return nomeRemove;
	}
	
}
