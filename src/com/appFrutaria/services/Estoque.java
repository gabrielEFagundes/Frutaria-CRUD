package com.appFrutaria.services;
import com.appFrutaria.model.Fruta;
import com.appFrutaria.view.Atendente;

import java.util.List;
import java.util.ArrayList;

// O services fará todos os processos, como deletar ou adicionar elementos
// Ele não mostrará nada, isso será feito pelo view.
public class Estoque {
	
	// Tipo List<Fruta>
	List<Fruta> estoqueFrutas;
	
	// Apenas instância o estoqueFrutas, não é tãooooo necessário
	public Estoque() {
		estoqueFrutas = new ArrayList<>();
		
	}
	
	public List<Fruta> getEstoqueFruta() {
		return estoqueFrutas;
	}
	
	public void setEstoqueFruta(List<Fruta> estoqueFrutas) {
		this.estoqueFrutas = estoqueFrutas;
	}
	
	// O método que vai fazer todas as coisas que o menu mostra
	public void gerenciarEstoque(int opcaoMenu, Atendente atendente, Fruta fruta) {
		
		// O case usado é apenas um case que não necessita de break
		switch(opcaoMenu) {
		// Adicionar fruta ao estoque
		case 1 -> {
				String nomeFruta = atendente.definirNome(); // Envia para o método do atendente, e armazena o retorno do método.
				
				double precoFruta = atendente.definirPreco();
				
				int qtdFruta = atendente.definirEstoque();

				// Adiciona os valores no construtor da fruta, instânciando a fruta passada anteriormente por parâmetro
				fruta = new Fruta(nomeFruta, precoFruta, qtdFruta);
				
				// Coloca a fruta no estoque
				estoqueFrutas.add(fruta);
			}
		
		// Mostrar todas as frutas armazenadas no Estoque estoqueFrutas
		case 2 -> {
				// Usa o atendente para chamar o método listarFrutas
				// passando o parâmetro da lista
				atendente.listarFrutas(estoqueFrutas);
			}
		
		// Remover uma fruta específicada pelo índice
		case 3 -> {
				int removerFruta = atendente.removerFrutas(estoqueFrutas); // Leva para o método do atendente e armazena o valor retornado
				estoqueFrutas.remove(removerFruta); // O valor retornado é utilizado para remover a fruta específica do estoqueFrutas
			}
		
		// Só sai do programa
		case 0 -> {
				System.out.println("\nSaindo do programa...");
				System.exit(0); // Isso é uma forma de sair do programa, retornando 0
			}
		}
		
	}
	
}
