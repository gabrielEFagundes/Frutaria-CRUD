package com.appFrutaria.view;

import java.util.List;
import java.util.Scanner;

import com.appFrutaria.model.Fruta;

// Aqui é a interação com o usuário
// Faz APENAS a intereção com o usuário, note que é a única classe com Scanner
public class Atendente {

	Scanner scan;
	
	// Apenas instância o Scanner, dá pra fazer em uma só linha (onde cria o scan)
	public Atendente() {
		scan = new Scanner(System.in);
		
	}
	
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	public Scanner getScan() {
		return scan;
	}
	
	// Classe do menu principal, para a interação do usuário
	public int menuPrincipal() {
		
		System.out.println("\n--- Frutaria Fagundes ---");
		System.out.printf("\n1- Cadastrar produto"
				+ "\n2- Listar produtos"
				+ "\n3- Remover produtos"
				+ "\n0- Sair"
				+ "\n-------------------------"
				+ "\nSua escolha: ");
		
		int escolhaMenu = scan.nextInt();
		
		return escolhaMenu; // Retorna o valor lá para a Main
		
	}
	
	// Método criado para a entrada de um nome para a fruta
	public String definirNome() {
		
		System.out.println("\nDefina o nome da fruta: ");
		String nomeFruta = scan.next();
		
		return nomeFruta; // A String é retornada para o Estoque e é armazenada lá
	}
	
	// Entrada de um preço para a fruta
	public double definirPreco() {
		
		System.out.println("\nDefina o preço da fruta: ");
		double precoFruta = scan.nextDouble();
		
		return precoFruta; // Mesma coisa, o valor double volta para o Estoque e é armazenado
	}
	
	// Entrada de um estoque para a fruta
	public int definirEstoque() {
		
		System.out.println("\nDefina o estoque da fruta: ");
		int estoqueFruta = scan.nextInt();
		
		return estoqueFruta; // Retorna para o Estoque e é adicionado no ArrayList estoqueFrutas
	}
	
	// Serve para mostrar todas as frutas que existem na lista estoqueFrutas
	public void listarFrutas(List<Fruta> estoqueFrutas) {
		
		System.out.println("");
		
		// Note que eu iterei entre os valores do estoqueFrutas
		// Sem isso, seria impresso apenas o endereço na memória do ArrayList
		for(Fruta i : estoqueFrutas) {
			System.out.println("Nome: " + i.getNome() + " | Preço: " + i.getPreco() + " | Quantidade: " + i.getQuantidade());
			// O 'i' do tipo Fruta permite o acesso para todos os métodos da Fruta, é quase um objeto não instânciado de Fruta
		}
	}
	
	
	public int removerFrutas(List<Fruta> estoqueFruta) {
		
		int cont = 1; // Serve apenas para mostrar um índice mais "amigável"
		System.out.println("");
		
		// Novamente, eu iterei entre todos os valores de estoqueFrutas
		for(Fruta i : estoqueFruta) {
			System.out.println(cont + "- " + i.getNome());
			cont++;
		}
		
		System.out.println("\nDigite o índice da fruta para remover: ");
		int nomeRemove = scan.nextInt();
		
		// Os índices mostrados começam em 1, mas os índices internos começam em 0
		// Então teoricamente, se o usuário digitasse 1 com a intenção de remover
		// o primeiro valor, ele removeria o segundo internamente
		// Por isso, é diminuído 1 do valor digitado pelo usuário, para que o valor
		// fique igualado com o valor interno do ArrayList
		nomeRemove -= 1;
		
		return nomeRemove; // Retorna o valor para o Estoque, para remover da lista conforme o índice
	}
	
}
