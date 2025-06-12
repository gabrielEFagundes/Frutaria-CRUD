package com.appFrutaria;

import com.appFrutaria.view.Atendente;
import com.appFrutaria.model.Fruta;
import com.appFrutaria.services.Estoque;

// Aqui é a main, a controladora de tudo
public class App {

	public static void main(String[] args) {
		
		Atendente atendente = new Atendente();
		Estoque estoque = new Estoque();
		Fruta fruta = new Fruta();
		
		
		int opcaoMenu = 0;
		
		
		do {
			// Guarda o valor retornado lá do Atendente na variável
			opcaoMenu = atendente.menuPrincipal();
			
			// Envia os parâmetros necessários para o método gerenciarEstoque
			// utilizando a instância estoque para acessar o estoque
			estoque.gerenciarEstoque(opcaoMenu, atendente, fruta);
		} while(opcaoMenu != 0);
		
	}

}
