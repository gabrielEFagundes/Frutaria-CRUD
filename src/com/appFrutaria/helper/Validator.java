package com.appFrutaria.helper;
import com.appFrutaria.view.Atendente;

public class Validator {
	
	static Atendente atendente = new Atendente();
	
	public static Integer valorPadrao;
	
	public Validator(Integer valorPadrao) {
		Validator.valorPadrao = null;
	}
	
	public static Integer validarInteger(String inteiro) {
		
		try {
			Integer escolhaFinal = Integer.parseInt(inteiro);
			
			return escolhaFinal;
			
		}catch(NumberFormatException erro) {
			atendente.erroMismatch();
			return valorPadrao;
		}
	}
	
	// TODO:
	// validar os doubles e os inteiros do cadastro e edição
	public static Double validarDouble(String real) {
		
		try {
			Double escolhaFinal = Double.parseDouble(real);
			
			return escolhaFinal;
			
		}catch(NumberFormatException erro) {
			atendente.erroMismatch();
			return (double) valorPadrao; // fiz um narrowing casting, pra voltar o valor como real
		}
	}
}