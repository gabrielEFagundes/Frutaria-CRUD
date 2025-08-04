package com.appFrutaria;

import com.appFrutaria.view.Atendente;
import com.appFrutaria.model.*;
import com.appFrutaria.services.Estoque;

// Aqui é a Main, a classe que vai controlar tudo, nesse caso, mandar o que cada um deve fazer
public class App {

	public static void main(String[] args) {
		
		// Cria todas as instâncias anteriormente criadas
		Atendente atendente = new Atendente();
		Estoque estoque = new Estoque();
		Produto fruta = new Fruta();
		Produto verdura = new Verdura();
		
		// Variável apenas para o loop
		int opcaoMenu = 0;
		
		do {
			// Guarda o valor retornado lá do Atendente na variável
			opcaoMenu = atendente.menuPrincipal();
			
			// Envia os parâmetros necessários para o método gerenciarEstoque
			// utilizando a instância estoque para acessar o estoque
			estoque.gerenciarEstoque(opcaoMenu, atendente, fruta, verdura);
		} while(opcaoMenu != 0);
		
	}
	
	/*
	 * A organização em pacotes transforma classes que anteriormente eram cheias de conteúdo,
	 * em classes muito mais limpas e simples, esse é o primeiro princípio SOLID, nesse caso,
	 * o S, 'Single Responsability Class', onde cada classe tem a sua própria responsabilidade.
	 * 
	 * Esse princípio deixa o programa mais eficiente e otimizado, além de facilitar muito na
	 * manutenção do código própriamente dita anteriormente
	 * 
	 * Em POO, esse princípio é extremamente importante, já que a organização é a base para
	 * o paradigma voltado à objetos, que se baseia em objetos da vida real, como a fruta,
	 * para deixar o código muito mais fácil de entender.
	 * 
	 * No exemplo da fruta, cada pacote tem uma classe responsável por algo, onde o Estoque
	 * serve apenas para gerenciar o mesmo, o Atendente serve apenas para fazer a interação
	 * com o usuário, a Fruta apenas guarda os dados entrados pelo usuário, servindo como um 
	 * "banco de dados", e por fim, o App (main) apenas serve para controlar cada uma dessas
	 * responsabilidades.
	 */

}
