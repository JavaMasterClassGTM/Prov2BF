package model;

/**
 * Classe permettant de factoriser les éléments communs à Client et Conseiller
 * Classe abstraite
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 *
 */
public abstract class Personne {
	private String nom;
	private String prenom;

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;

	}

	public Personne() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return"nom: " + nom + ", prénom : " + prenom;
	}
}
