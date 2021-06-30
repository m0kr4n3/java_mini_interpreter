package com.src.TP_POO;

import java.util.ArrayList;

class Interpreteur{
	private ArrayList<String> tabSymboles;

	public void lancerShell(){
		
	}

	private void initTabSymboles(){

	}

	public Symbole readSymbole(){

		return new Symbole();
	}

	public void addOrUpdateSymbole(Symbole symbole) throws MotCleReserveException{

	}

	public Commande InterpreterLigne(String ligne) throws MissingArgumentException, CommandNotFoundException{
		return new Commande() {};
	}
}

class Symbole{
	protected String nom;
}

//class Fonction extends Symbole{
//	private functionObject code;
//}

class Variable extends Symbole{
	public Variable(String var){
		try{
			this.verifierSyntaxe(var);
		}catch(){

		}
	}
	private double valeur;
	private void verifierSyntaxe(String var) {
		try{
			
		}catch(){

		}
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
}

abstract class Commande extends Symbole{
	
}

class Print extends Commande{

}

class Let extends Commande{

}

class main{
	public static void main(String[] args) {
		System.out.println("a");
	}
}  