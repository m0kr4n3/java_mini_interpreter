package com.src.TP_POO;

public class SyntaxeException extends Exception {
	@Override
	public String getMessage() {
		return "Erreur : Nom de variable erroné.";
	}
}
