package com.src.TP_POO;

public class ParentheseOuvranteManquanteException extends Exception{
	@Override
	public String getMessage() {
		return "Erreur : Parenthése ouvrante manquante.";
	}
}
