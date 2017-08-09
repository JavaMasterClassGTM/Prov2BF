package model;

import java.util.Date;

/**
 * Classe permettant de factoriser les éléments communs aux comptes épargne et courant
 * Classe abstraite
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 *
 */
public class CompteBancaire {
	private double soldeCompte;
	private Date dateOuverture;
	private int numeroCompte;
	private int i = 14;


	public CompteBancaire(double soldeCompte, Date dateOuverture) {
		this.soldeCompte = soldeCompte;
		this.dateOuverture = dateOuverture;
		++i;
		numeroCompte = i;
		
	}

		
	public CompteBancaire() {
		super();
		++i;
		numeroCompte = i;
	}



	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;

	}

	public double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
		if (soldeCompte > 500000) {
			
		}
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date d) {
		this.dateOuverture = d;
	}

	@Override
	public String toString() {
		return "Numero " + getNumeroCompte() + ", Solde = " + getSoldeCompte() + " euros, Date d'ouverture : "
				+ getDateOuverture();
	}

}
