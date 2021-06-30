package com.src.TP_POO;

import java.util.HashMap;

class TableDesSymboles{
	private HashMap<String,Symbole> tabSymboles;


	public TableDesSymboles() {
		this.tabSymboles = new HashMap<String,Symbole>();
	}

	static void initTabSymboles(){
		this.tabSymboles.put("print",new Print("print"));
		this.tabSymboles.put("let",new Print("Let"));
		this.tabSymboles.put("cos",new );
		
	}

	private Symbole readSymbole(String key)throws SymboleNonTrouveException{

	}

	public void addOrUpdateSymbole(Symbole symbole) throws MotCleReserveException{
		if(tabSymboles.containsKey(symbole.nom)){
			Symbole symb = this.tabSymboles.get(symbole.nom);
			if(!(symb instanceof Variable))	throw new MotCleReserveException();
			symb.setNom(symbole.getNom());
		}else{
			this.tabSymboles.put(symbole.getNom(), symbole);
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

interface FunInter{
	public double doSmth(double d);
}

class Fonction extends Symbole{
	private FunInter func;

	public Fonction(FunInter func){
		this.func = func;
	}

	public double excec(double d){
		return this.func.doSmth(d);
	}
}

class Variable extends Symbole{
	
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