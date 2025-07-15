package com.appFrutaria.services;
import com.appFrutaria.model.*;
import com.appFrutaria.view.Atendente;

import java.util.List;
import java.util.ArrayList;

// O services fará todos os processos, como deletar ou adicionar elementos
// Ele não mostrará nada, isso será feito pelo view.
public class Estoque {
	
	List<Produto> estoqueProdutos;
	
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
						atendente.erroDigitacao();
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
							for(Produto i : estoqueProdutos) {
								if(i instanceof Fruta f) {
									atendente.listarFrutas(f);
									
							}
						}
					}
					case 2 -> {
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
							boolean encontrado = false;
							int indiceRemove = atendente.removerFruta(estoqueProdutos);
							
							for(int valor = 0; valor < estoqueProdutos.size(); valor++) {
								if(indiceRemove == valor) {
									estoqueProdutos.remove(indiceRemove);
									encontrado = true;
								}
							}
							if(encontrado == false) {
								atendente.erroNotFound();
							}
						}
					
					case 2 -> {
							boolean encontrado = false;
							int indiceRemove = atendente.removerFruta(estoqueProdutos);
							
							for(int valor = 0; valor < estoqueProdutos.size(); valor++) {
								if(indiceRemove == valor) {
									estoqueProdutos.remove(indiceRemove);
									encontrado = true;
								}
							}
							if(encontrado == false) {
								atendente.erroNotFound();
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
				atendente.erroDigitacao();
			}
		}
		
	}
	
}
