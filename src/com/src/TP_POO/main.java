package com.src.TP_POO;

import java.util.ArrayList;

class main{
	public static void main(String[] args) {
		TableDesSymboles tabSymboles = new TableDesSymboles();
		Interpreteur inter = new Interpreteur();

		Print pr = new Print("Print");

		// inter.lancerShell(tabSymboles);

		Expression exp = new Expression("(12.3+13.4 * sin(1.9+2.4  ) / 7.29 * 2.08 )");
		try{
			inter.lancerShell(tabSymboles);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}  