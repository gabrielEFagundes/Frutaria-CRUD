package com.appFrutaria.services;
import com.appFrutaria.model.*;
import com.appFrutaria.view.Atendente;

import java.util.List;
import java.util.ArrayList;

// O services fará todos os processos, como deletar ou adicionar elementos
// Ele não mostrará nada, isso será feito pelo view.
public class Estoque {
	
	List<Produto> estoqueProdutos;
	boolean encontrado = false; // para exclusão / edição
	int cont = 0, indice = 0; // também para exclusão / edição
	
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
				int escolhaCadastro = atendente.escolhaGeral();
				
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
					int escolhaListar = atendente.escolhaGeral();
					
					switch(escolhaListar) {
					case 1 -> {		
							atendente.listarFrutasTitle();
							
							for(Produto i : estoqueProdutos) {
								if(i instanceof Fruta f) {
									atendente.listarFrutas(f);
									cont++;
									
								}
							}
							
							if(cont == 0) {
								atendente.erroCadastro();
							}
					}
					case 2 -> {
							atendente.listarVerdurasTitle();
						
							for(Produto i : estoqueProdutos) {
								if(i instanceof Verdura v) {
									atendente.listarVerduras(v);
									cont++;
									
								}
							}
							
							if(cont == 0) {
								atendente.erroCadastro();
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
							indice = 1;
							atendente.listarTitleSimples();
							for(Produto i : estoqueProdutos) {
								if(i instanceof Fruta f) {
									atendente.listarFrutasSimples(f, indice);
									indice++;
									cont++;
								}
							}
							
							if(cont == 0) {
								atendente.erroCadastro();
								break;
							}
							
							int indiceRemove = atendente.removerIndice();
							
							// Os índices mostrados começam em 1, mas os índices internos começam em 0
							// Então teoricamente, se o usuário digitasse 1 com a intenção de remover
							// o primeiro valor, ele removeria o segundo internamente
							// Por isso, é diminuído 1 do valor digitado pelo usuário, para que o valor
							// fique igualado com o valor interno do ArrayList
							indiceRemove--;
							
							for(int i = 0; i < estoqueProdutos.size(); i++) {
								if(estoqueProdutos.get(i) instanceof Fruta && i == indiceRemove) {
									encontrado = true;
									estoqueProdutos.remove(indiceRemove);
									atendente.sucesso();
								}
							}
							
							if(encontrado == false) {
								atendente.erroNotFound();
							}
							cont = 0;
						}
					
					case 2 -> {
							indice = 1;
							atendente.listarTitleSimples();
							for(Produto i : estoqueProdutos) {
								if(i instanceof Verdura v) {
									atendente.listarVerduraSimples(v, indice);
									indice++;
									cont++;
								}
							}
							
							if(cont == 0) {
								atendente.erroCadastro();
								break;
							}
							
							int indiceRemove = atendente.removerIndice();
							
							indiceRemove--;
							
							for(int i = 0; i < estoqueProdutos.size(); i++) {
								if(estoqueProdutos.get(i) instanceof Verdura && i == indiceRemove) {
									encontrado = true;
									estoqueProdutos.remove(indiceRemove);
									atendente.sucesso();
								}
							}
							
							if(encontrado == false) {
								atendente.erroNotFound();
							}
							cont = 0;
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
		
		case 4 -> {
				if(estoqueProdutos.isEmpty()) {
					atendente.erroListaVazia();
					
				}else {
					int escolhaEdicao = atendente.escolhaGeral();
					
					switch(escolhaEdicao) {
					case 1 -> {
							indice = 1;
							atendente.listarTitleSimples();
							for(Produto i : estoqueProdutos) {
								if(i instanceof Fruta f) {
									atendente.listarFrutasSimples(f, indice);
									indice++;
									cont++;
								}
							}

							if(cont == 0) {
								atendente.erroCadastro();
								break;
								
							}else {
							
								int indiceEdicao = atendente.editarIndice();
								indiceEdicao--;
								
								for(int i = 0; i < estoqueProdutos.size(); i++) {
									if(estoqueProdutos.get(i) instanceof Fruta && i == indiceEdicao) {
										encontrado = true;
										Produto f = atendente.editarFruta(fruta);
										estoqueProdutos.set(indiceEdicao, f);
										atendente.sucesso();
									}
								}
								
								if(encontrado == false) {
									atendente.erroNotFound();
								}
							}
							// só pra voltar ao valor original após este case
							cont = 0;
						}
					
					case 2 -> {
							indice = 1;
							atendente.listarTitleSimples();
							for(Produto i : estoqueProdutos) {
								if(i instanceof Verdura v) {
									atendente.listarVerduraSimples(v, indice);
									indice++;
									cont++;
								}
							}
							
							if(cont == 0) {
								atendente.erroCadastro();
								break;
							}
							
							int indiceEdicao = atendente.editarIndice();
							indiceEdicao--;
							
							for(int i = 0; i < estoqueProdutos.size(); i++) {
								if(estoqueProdutos.get(i) instanceof Verdura && i == indiceEdicao) {
									encontrado = true;
									Produto v = atendente.editarVerdura(verdura);
									estoqueProdutos.set(indiceEdicao, v);
								}
							}
							
							if(encontrado == false) {
								atendente.erroNotFound();
							}
							cont = 0;
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