package model;

import java.util.Date;

/**
 * Objet métier : Javabean CompteCourant
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 */
public class CompteCourant extends CompteBancaire {
	public double autorisationDecouvert = -1000;

	public CompteCourant(double soldeCompte, Date dateOuverture, double autorisationDecouvert, int numeroCompte) {
		super(soldeCompte, dateOuverture);
		super.setNumeroCompte(numeroCompte);
		this.autorisationDecouvert = autorisationDecouvert;
	}
	
	public CompteCourant(double soldeCompte, Date dateOuverture, double autorisationDecouvert) {
		super(soldeCompte, dateOuverture);
		this.autorisationDecouvert = autorisationDecouvert;
	}
	
	public CompteCourant() {
		super();
	}

	
	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

//	public void setAutorisationDecouvert(double autorisationDecouvert) {
//		this.autorisationDecouvert = autorisationDecouvert;
//	}

}
