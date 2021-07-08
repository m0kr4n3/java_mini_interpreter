package com.src.TP_POO;

public class SigneEgalManquantException extends Exception{
	@Override
	public String getMessage() {
		return "Signe egal Manquant";
	}
}
