package com.src.TP_POO;

public class MotCleReserveException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "le Nom de variable est un mot clee reservé";
	}
}
