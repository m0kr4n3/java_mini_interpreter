package src;

import java.util.HashMap;
import java.util.Map.Entry;

class TableDesSymboles{
	private HashMap<String,Symbole> tabSymboles;


	public TableDesSymboles() {
		this.tabSymboles = new HashMap<String,Symbole>();
		initTabSymboles();
	}

	private void initTabSymboles(){
		this.tabSymboles.put("print",new Print("print"));
		this.tabSymboles.put("let",new Let("let"));
		this.tabSymboles.put("end",new End("end"));

		//	toutes les fonctions standards
		this.tabSymboles.put("cos",	new Fonction("cos",Math::cos));
		this.tabSymboles.put("sin",	new Fonction("sin",Math::sin));
		this.tabSymboles.put("tan",	new Fonction("tan",Math::tan));
		this.tabSymboles.put("sqrt",	new Fonction("sqrt",Math::sqrt));
		this.tabSymboles.put("abs",	new Fonction("abs",Math::abs));
		this.tabSymboles.put("log",	new Fonction("log",Math::log));
	
	}

	public Symbole readSymbole(String key){

		Symbole s = this.tabSymboles.get(key);
		return s;
	}

	public void addOrUpdateSymbole(Symbole symbole) throws MotCleReserveException{
		if(tabSymboles.containsKey(symbole.getNom())){
			Symbole symb = this.tabSymboles.get(symbole.getNom());
			if(!(symb instanceof Variable))	throw new MotCleReserveException();
			
			((Variable)symb).setValeur(((Variable)symbole).getValeur());
		}else{
			this.tabSymboles.put(symbole.getNom().trim(), symbole);
		}
	}

	//	retourne le symbole print ou let si c'est une commande
	//	null sinon
	public Commande isItCommande(Symbole symbole){
		if( this.tabSymboles.containsKey(symbole.getNom()) ){
			//	on vérifie si il est de type symbole
			Symbole symb = this.readSymbole(symbole.getNom().trim());
			if( symb instanceof Commande){
				return (Commande)symb;
			}else{	//	evidently impossible
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}