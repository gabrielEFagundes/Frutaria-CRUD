package com.appFrutaria.view;
import com.appFrutaria.helper.Validator;

import java.util.Scanner;

import com.appFrutaria.model.*;

// Aqui é a interação com o usuário
public class Atendente {

	public static final String RESET = "\033[0m", VERDE = "\033[0;32m", AMARELO = "\033[1;33m", VERMELHO = "\033[1;31m", CINZA = "\033[0;90m";
	
	private Integer valorRetornado, valorFinal;
	private String escolha;
	
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
	
	public Integer menuPrincipal() {
		
		while(valorRetornado == null) {
			System.out.print("\n+----------- " + VERDE + "Frutaria Fagundes" + RESET + " --+"
							+ "\n|" + AMARELO + " 1- " + RESET + "Cadastrar produto           |"
							+ "\n|" + AMARELO + " 2- " + RESET + "Listar produtos             |"
							+ "\n|" + AMARELO + " 3- " + RESET + "Remover produtos            |"
							+ "\n|" + AMARELO + " 4- " + RESET + "Editar produtos             |"
							+ "\n|" + AMARELO + " 0- " + RESET + "Sair                        |"
							+ "\n+--============================--+"
							+ "\n Sua escolha: ");
			
			escolha = scan.next();
			
			valorRetornado = Validator.validarInteger(escolha);
			valorFinal = valorRetornado;
		}
		valorRetornado = null;
		return valorFinal;
	}
	
	public Integer escolhaGeral() {
		System.out.print("\nQual dos produtos?"
				+ "\n1- Frutas"
				+ "\n2- Verduras"
				+ "\nSua escolha: ");
		
		escolha = scan.next();
		
		valorRetornado = Validator.validarInteger(escolha);
		valorFinal = valorRetornado;
		
		valorRetornado = null;
		return valorFinal;
	}
	
	public Produto cadastrarFruta(Produto fruta) {
		scan.nextLine();
		
		System.out.print("\nDefina o nome da fruta: ");
		String nomeFruta = scan.nextLine();
		
		System.out.print("\nDefina o preço da fruta: ");
		double precoFruta = scan.nextDouble();
		
		System.out.print("\nDefina o estoque da fruta: ");
		int estoqueFruta = scan.nextInt();
		
		System.out.print("\nDefina o peso da fruta: ");
		double pesoFruta = scan.nextDouble();
		
		fruta = new Fruta(nomeFruta, precoFruta, estoqueFruta, pesoFruta);
		
		return fruta;
	}
	
	public Produto cadastrarVerdura(Produto verdura) {
		scan.nextLine();
		
		System.out.print("\nDefina o nome da verdura: ");
		String nomeVerdura = scan.nextLine();
		
		System.out.print("\nDefina o preço da verdura: ");
		double precoVerdura = scan.nextDouble();
		
		System.out.print("\nDefina o estoque da verdura: ");
		int estoqueVerdura = scan.nextInt();
		
		System.out.print("\nDefina o tipo da verdura: ");
		String tipoVerdura = scan.next();
		
		verdura = new Verdura(nomeVerdura, precoVerdura, estoqueVerdura, tipoVerdura);
		
		return verdura;
	}
	
	public void listarFrutasTitle() {
		System.out.println("\n\n+-- NOME -------------- + -- PREÇO ------ + -- QTD ------ + -- PESO ------+");
	}
	
	public void listarFrutas(Produto f) {
		System.out.println(f);
		
	}
	
	public void listarVerdurasTitle() {
		System.out.println("\n\n+-- NOME -------------- + -- PREÇO ------ + -- QTD ------ + -- TIPO ------+");
	}
	
	public void listarVerduras(Produto v) {
		System.out.println(v);
	}
	
	public Integer escolhaRemover() {
		System.out.print("\nQual produto você quer remover?"
				+ "\n1- Fruta"
				+ "\n2- Verdura"
				+ "\n3- Limpar Tudo " + VERMELHO + "(PERIGOSO)" + RESET
				+ "\nSua escolha: ");
		
		escolha = scan.next();
		
		valorRetornado = Validator.validarInteger(escolha);
		valorFinal = valorRetornado;
		
		valorRetornado = null;
		return valorFinal;
	}
	
	public void listarTitleSimples() {
		System.out.print("\n\n+-- ID ---- + -- NOME ------------+");
	}
	
	public void listarFrutasSimples(Fruta f, int cont) {
		System.out.printf("\n| %-9d | %-19s |"
					  + "\n+---------------------------------+", cont, f.getNome());
	}
	
	public void listarVerduraSimples(Verdura v, int cont) {
		System.out.printf("\n| %-9d | %-19s |"
				  + "\n+---------------------------------+", cont, v.getNome());
	}
	
	public int removerIndice() {
		
		System.out.print("\n\nDigite o índice da fruta para remover: ");
		int nomeRemove = scan.nextInt();
		
		return nomeRemove;
	}
	
	public int editarIndice() {
		System.out.print("\n\nDigite o índice da fruta para editar: ");
		int nomeEdita = scan.nextInt();
		
		return nomeEdita;
	}
	
	public Produto editarFruta(Produto fruta) {
		scan.nextLine();
		
		System.out.print("\nDigite o novo nome da fruta: ");
		String novoNome = scan.nextLine();
		
		System.out.print("\nDigite o novo preço da fruta: ");
		double novoPreco = scan.nextDouble();
		
		System.out.print("\nDigite a nova quantidade da fruta: ");
		int novaQtd = scan.nextInt();
		
		System.out.print("\nDigite o novo peso da fruta: ");
		double novoPeso = scan.nextDouble();
		
		fruta = new Fruta(novoNome, novoPreco, novaQtd, novoPeso);
		
		return fruta;
	}
	
	public Produto editarVerdura(Produto verdura) {
		scan.nextLine();
		
		System.out.print("\nDigite o novo nome da verdura: ");
		String novoNome = scan.nextLine();
		
		System.out.print("\nDigite o novo preço da verdura: ");
		double novoPreco = scan.nextDouble();
		
		System.out.print("\nDigite a nova quantidade da verdura: ");
		int novaQtd = scan.nextInt();
		
		System.out.print("\nDigite o novo tipo da verdura: ");
		String novoTipo = scan.next();
		
		verdura = new Verdura(novoNome, novoPreco, novaQtd, novoTipo);
		
		return verdura;
	}
	
	public void sucesso() {
		System.out.println(VERDE + "\n✓ Processo terminado com êxito!" + RESET);
	}
	
	public char confirmacao() {
		System.out.print("\nTêm certeza que quer fazer esta ação? Ela não pode ser desfeita! (s/n)"
				+ "\n-> ");
		
		char confirma = scan.next().charAt(0);
		
		return confirma;
	}
	
	public void cancelarAcao() {
		System.out.println(AMARELO + "\nAção cancelada com êxito." + RESET);
	}
	
	public void erroListaVazia() {
		System.out.print(VERMELHO + "\nErro! A lista parece estar vazia..." + RESET);
	}
	
	public void erroNotFound() {
		System.out.print(VERMELHO + "\nErro! O valor não foi encontrado..." + RESET);
	}
	
	public void erroCadastro() {
		System.out.print(VERMELHO + "\nErro! Não foi encontrado nenhum valor cadastrado..." + RESET);
	}
	
	public void erroMismatch() {
		System.out.print(VERMELHO + "\nErro! Digite um valor válido." + RESET);
	}	
}