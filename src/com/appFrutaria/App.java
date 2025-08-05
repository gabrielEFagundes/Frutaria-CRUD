package com.appFrutaria;

import com.appFrutaria.view.Atendente;
import com.appFrutaria.model.*;
import com.appFrutaria.services.Estoque;

// Aqui é a Main, a classe que vai controlar tudo
public class App {

	public static void main(String[] args) {
		
		Atendente atendente = new Atendente();
		Estoque estoque = new Estoque();
		Produto fruta = new Fruta();
		Produto verdura = new Verdura();
		
		int opcaoMenu = 0;
		
		do {
			opcaoMenu = atendente.menuPrincipal();
			
			estoque.gerenciarEstoque(opcaoMenu, atendente, fruta, verdura);
		} while(opcaoMenu != 0);
	}
}
