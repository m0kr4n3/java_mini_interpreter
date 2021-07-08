package com.src.TP_POO;

public class IncorrectOperandeException extends Exception{
	@Override
	public String getMessage() {
		return "Un des operande est incorrect.";
	}
	
}
