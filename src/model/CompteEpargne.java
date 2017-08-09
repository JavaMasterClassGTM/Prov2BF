package model;

import java.util.Date;

/**
 * Objet métier : Javabean CompteEpargne
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 */
public class CompteEpargne extends CompteBancaire {
double tauxRemuneration = 0.03;

	public CompteEpargne(double soldeCompte, Date dateOuverture, double tauxRemuneration, int numeroCompte) {
		super(soldeCompte, dateOuverture);
		super.setNumeroCompte(numeroCompte);
		this.tauxRemuneration = tauxRemuneration;
	}
	
	public CompteEpargne(double soldeCompte, Date dateOuverture, double tauxRemuneration) {
		super(soldeCompte, dateOuverture);
		this.tauxRemuneration = tauxRemuneration;
	}
	
	public CompteEpargne() {
		super();
	}


	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	

}
