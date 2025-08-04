package com.appFrutaria.helper;
import com.appFrutaria.view.Atendente;

public class Validator {
	
	static Atendente atendente = new Atendente();
	
	public static Integer valorPadrao = null;
	
	public static Integer validarEntrada(String escolha) {
		
		try {
			Integer escolhaFinal = Integer.parseInt(escolha);
			
			return escolhaFinal;
			
		}catch(NumberFormatException erro) {
			atendente.erroMismatch();
			return valorPadrao;
		}
	}
}