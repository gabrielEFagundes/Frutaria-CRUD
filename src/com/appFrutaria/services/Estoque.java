package com.appFrutaria.services;
import com.appFrutaria.model.*;
import com.appFrutaria.view.Atendente;

import java.util.List;
import java.util.ArrayList;

// O services fará todos os processos, como deletar ou adicionar elementos
// Ele não mostrará nada, isso será feito pelo view.
public class Estoque {
	
	List<Produto> estoqueProdutos;
	boolean encontrado = false; // para exclusão
	int cont = 0; // também para exclusão
	
	public Estoque() {
		estoqueProdutos = new ArrayList<>();
		
	}
	
	public List<Produto> getEstoqueProdutos() {
		return estoqueProdutos;
	}
	
	public void setEstoqueFruta(List<Produto> estoqueProdutos) {
		this.estoqueProdutos = estoqueProdutos;
	}
	
	public void gerenciarEstoque(int opcaoMenu, Atendente atendente, Produto fruta, Produto verdura) {
		
		switch(opcaoMenu) {
		case 1 -> {
				int escolhaCadastro = atendente.escolhaCadastro();
				
				switch(escolhaCadastro) {
				case 1 -> {
						Produto f = atendente.cadastrarFruta(fruta);
						estoqueProdutos.add(f);
					}
				
				case 2 -> {
						Produto v = atendente.cadastrarVerdura(verdura);
						estoqueProdutos.add(v);
					}
				
				default -> {
						atendente.erroNotFound();
					}
				}
			}
		
		case 2 -> {
				if(estoqueProdutos.isEmpty()) {
					atendente.erroListaVazia();
					
				}else {
					int escolhaListar = atendente.listarEscolha();
					
					switch(escolhaListar) {
					case 1 -> {		
							atendente.listarFrutasTitle();
							
							for(Produto i : estoqueProdutos) {
								if(i instanceof Fruta f) {
									atendente.listarFrutas(f);
									
							}
						}
					}
					case 2 -> {
							atendente.listarVerdurasTitle();
						
							for(Produto i : estoqueProdutos) {
								if(i instanceof Verdura v) {
									atendente.listarVerduras(v);
									
								}
							}
						}
					}
				}
		}
		
		case 3 -> {
			
				if(estoqueProdutos.isEmpty()) {
					atendente.erroListaVazia();
					
				}else {
					int escolhaRemover = atendente.escolhaRemover();
					
					switch(escolhaRemover) {
					case 1 -> {
							int indiceRemove = atendente.removerFruta(estoqueProdutos);
							
							// Os índices mostrados começam em 1, mas os índices internos começam em 0
							// Então teoricamente, se o usuário digitasse 1 com a intenção de remover
							// o primeiro valor, ele removeria o segundo internamente
							// Por isso, é diminuído 1 do valor digitado pelo usuário, para que o valor
							// fique igualado com o valor interno do ArrayList
							indiceRemove -= 1;
							
							for(int i = 0; i < estoqueProdutos.size(); i++) {
								if(estoqueProdutos.get(i) instanceof Fruta && cont == indiceRemove) {
									estoqueProdutos.remove(indiceRemove);
									encontrado = true;
									atendente.sucesso();
								}else {
									cont++;
								}
							}
							if(encontrado == false) {
								atendente.erroNotFound();
							}
						}
					
					case 2 -> {
							int indiceRemove = atendente.removerFruta(estoqueProdutos);
							
							indiceRemove -= 1;
							
							for(int i = 0; i < estoqueProdutos.size(); i++) {
								if(estoqueProdutos.get(i) instanceof Verdura && cont == indiceRemove) {
									estoqueProdutos.remove(indiceRemove);
									encontrado = true;
									atendente.sucesso();
								}else {
									cont++;
								}
							}
							if(encontrado == false) {
								atendente.erroNotFound();
							}
						}
					
					case 3 -> {
							char confirma = atendente.confirmacao();
							
							if(confirma == 's' || confirma == 'S') {
								estoqueProdutos.clear();
								
							}else {
								atendente.cancelarAcao();
								
							}
						}
					}
				}
			}
		
		case 0 -> {
				System.out.println("\nSaindo do programa...");
				System.exit(0);
			}
		
		default -> {
				atendente.erroNotFound();
			}
		}
		
	}
}