package com.src.TP_POO;

import java.util.HashMap;
import com.src.*;
class TableDesSymboles{
	private HashMap<String,Symbole> tabSymboles = new HashMap<String,Symbole>();

	private void initTabSymboles(){
		
	}

	public Symbole readSymbole(String key) throws SymboleNonTrouveException{
		return null;

	}

	public void addOrUpdateSymbole(Symbole symbole) throws MotCleReserveException{
		if(this.tabSymboles.containsKey(symbole.nom)){

		}
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

class Interpreteur{

	public void lancerShell(){

	}

	public Commande InterpreterLigne(String ligne) throws MissingArgumentException, CommandNotFoundException{
		return new Commande() {};
	}
}

class Symbole{
	protected String nom;

	public Symbole(){}
	public Symbole(String nom){
		this.nom = nom;
	}

	public String getNom(){		return this.nom;}
	public void setNom(String nom){	this.nom = nom;}
	
}

//class Fonction extends Symbole{
//	private functionObject code;
//}

class Variable extends Symbole{
	Variable(String var,TableDesSymboles tab){
		super(var);
		try{
			this.verifierSyntaxe(var);
			tab.readSymbole(var);
		}catch(Exception e){

		}
	}
	private double valeur;
	private void verifierSyntaxe(String var) throws SyntaxeException {
		if (Utils.isNumeric(String.valueOf(var.toCharArray()[0])) == true) throw new SyntaxeException()

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