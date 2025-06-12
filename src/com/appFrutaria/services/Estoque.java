package com.appFrutaria.services;
import com.appFrutaria.model.Fruta;
import com.appFrutaria.view.Atendente;

import java.util.List;
import java.util.ArrayList;

// O services fará todos os processos, como deletar ou adicionar elementos
public class Estoque {
	
	// Tipo List<Fruta>
	List<Fruta> estoqueFrutas;
	
	public Estoque() {
		estoqueFrutas = new ArrayList<>();
		
	}
	
	public List<Fruta> getEstoqueFruta() {
		return estoqueFrutas;
	}
	
	public void setEstoqueFruta(List<Fruta> estoqueFrutas) {
		this.estoqueFrutas = estoqueFrutas;
	}
	
	
	public void gerenciarEstoque(int opcaoMenu, Atendente atendente, Fruta fruta) {
		
		switch(opcaoMenu) {
		case 1 -> {
				String nomeFruta = atendente.definirNome();
				
				double precoFruta = atendente.definirPreco();
				
				int qtdFruta = atendente.definirEstoque();

				// Adiciona os valores no construtor da fruta
				fruta = new Fruta(nomeFruta, precoFruta, qtdFruta);
				
				// Coloca a fruta no estoque
				estoqueFrutas.add(fruta);
			}
		
		
		case 2 -> {
				// Usa o atendente para chamar o método listarFrutas
				// passando o parâmetro da lista
				atendente.listarFrutas(estoqueFrutas);
			}
		
		
		case 3 -> {
				int removerFruta = atendente.removerFrutas(estoqueFrutas);
				estoqueFrutas.remove(removerFruta);
			}
		
		
		case 0 -> {
				System.out.println("\nSaindo do programa...");
				System.exit(0);
			}
		}
		
	}
	
}
