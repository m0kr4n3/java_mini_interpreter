package com.src.TP_POO;

class Variable extends Symbole{

	private double valeur;

	Variable(String name,double valeur,TableDesSymboles tab)throws SyntaxeException,OperateurManquantException {
		super(name);
	
		verifierSyntaxe();
		this.valeur = valeur;
	
	}
	private void verifierSyntaxe() throws SyntaxeException,OperateurManquantException {
		if (this.getNom().isEmpty())						 	throw new OperateurManquantException();
		if (Utils.isNumeric(String.valueOf(this.getNom().toCharArray()[0])) == true)	throw new SyntaxeException();
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
}