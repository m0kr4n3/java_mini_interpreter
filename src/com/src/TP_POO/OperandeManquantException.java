package com.src.TP_POO;

public class OperandeManquantException extends Exception{
	@Override
	public String getMessage() {
		return "Erreur : Operande manquant.";
	}
	
}
