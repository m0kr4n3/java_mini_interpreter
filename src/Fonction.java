package src;


interface FunInter{
	public double doSmth(double d);
}

class Fonction extends Symbole{
	private FunInter func;

	public Fonction(String nom,FunInter func){
		super(nom);
		this.func = func;
	}

	public double excec(double d){
		return this.func.doSmth(d);
	}
}