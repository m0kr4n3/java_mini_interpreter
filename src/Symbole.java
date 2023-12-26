package src;

class Symbole{
	private String nom;

	public Symbole(){}
	public Symbole(String nom){
		this.nom = nom;
	}

	public String getNom(){		return this.nom;}
	public void setNom(String nom){	this.nom = nom;}
	
	@Override
	public int hashCode() {
		return nom.hashCode();
	}
}
