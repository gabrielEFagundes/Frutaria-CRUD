package com.appFrutaria.view;

import java.util.List;
import java.util.Scanner;

import com.appFrutaria.model.*;

// Aqui é a interação com o usuário
// Faz APENAS a intereção com o usuário, note que é a única classe com Scanner
public class Atendente {

	public final String RESET = "\033[0m";
	public final String VERDE = "\033[0;32m";
	public final String AMARELO = "\033[1;33m";
	
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
		
		System.out.println("\n+----------- " + VERDE + "Frutaria Fagundes" + RESET + " --+"
						+ "\n|" + AMARELO + " 1- " + RESET + "Cadastrar produto           |"
						+ "\n|" + AMARELO + " 2- " + RESET + "Listar produtos             |"
						+ "\n|" + AMARELO + " 3- " + RESET + "Remover produtos            |"
						+ "\n|" + AMARELO + " 0- " + RESET + "Sair                        |"
						+ "\n+--============================--+"
						+ "\n Sua escolha: ");
		
		int escolhaMenu = scan.nextInt();
		
		return escolhaMenu;
		
	}
	
	public int escolhaCadastro() {
		System.out.print("\nO que você deseja cadastrar?"
				+ "\n1- Fruta"
				+ "\n2- Verdura"
				+ "\nSua escolha: ");
		
		int escolha = scan.nextInt();
		
		return escolha;
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
	
	public int listarEscolha() {
		System.out.print("\nO que você deseja listar?"
				+ "\n1- Frutas"
				+ "\n2- Verduras"
				+ "\nSua escolha: ");
		
		int escolha = scan.nextInt();
		
		return escolha;
	}
	
	public void listarFrutas(Produto f) {
		System.out.println(f);
		
	}
	
	public void listarVerduras(Produto v) {
		System.out.println(v);
	}
	
	public int escolhaRemover() {
		System.out.println("\nQual produto você quer remover?"
				+ "\n1- Fruta"
				+ "\n2- Verdura"
				+ "\nSua escolha: ");
		
		int escolha = scan.nextInt();
		
		return escolha;
	}
	
	public int removerFruta(List<Produto> estoqueProdutos) {
		
		int cont = 1;
		System.out.println("");
		
		System.out.println("\nDigite o índice da fruta para remover: ");
		int nomeRemove = scan.nextInt();
		
		// Os índices mostrados começam em 1, mas os índices internos começam em 0
		// Então teoricamente, se o usuário digitasse 1 com a intenção de remover
		// o primeiro valor, ele removeria o segundo internamente
		// Por isso, é diminuído 1 do valor digitado pelo usuário, para que o valor
		// fique igualado com o valor interno do ArrayList
		nomeRemove -= 1;
		
		return nomeRemove;
	}
	
	public void erroDigitacao() {
		System.err.println("\nErro! O digito não existe...");
	}
	
	public void erroListaVazia() {
		System.err.println("\nErro! A lista parece estar vazia...");
	}
	
	public void erroNotFound() {
		System.err.println("\nErro! O valor não foi encontrado...");
	}
	
}
