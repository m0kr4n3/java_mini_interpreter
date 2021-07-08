package com.src.TP_POO;

public class DivisionParZeroException extends Exception{
	@Override
	public String getMessage() {
		return "Division par zero.";
	}
}
