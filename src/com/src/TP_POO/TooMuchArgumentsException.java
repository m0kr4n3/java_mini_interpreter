package com.src.TP_POO;

public class TooMuchArgumentsException extends Exception{
	@Override
	public String getMessage() {
		return "Trop D'arguements entrés.";
	}
}
