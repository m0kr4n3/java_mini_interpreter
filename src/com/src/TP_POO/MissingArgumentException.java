package com.src.TP_POO;

public class MissingArgumentException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Erreur : argument manquant.";
	}
}
