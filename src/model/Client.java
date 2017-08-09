package model;

/**
 * Objet métier : Javabean Client
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 */
public class Client extends Personne {
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private int idce;
	private int idcc;
	private int idClient;
	
	public Client(String nom, String prenom, String email, String adresse, String codePostal, String ville) {
		super(nom, prenom);
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Client(String nom, String prenom, String email, String adresse, String codePostal, String ville, int idClient) {
		super(nom, prenom);
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idClient=idClient;
	}

	public Client(String nom, String prenom, String email, String adresse, String codePostal, String ville, int idClient, int idcc, int idce) {
		super(nom, prenom);
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idClient=idClient;
		this.idcc=idcc;
		this.idce=idce;
	}

	public int getIdce() {
		return idce;
	}

	public int getIdcc() {
		return idcc;
	}

	public Client() {
		super();

	}

	
	public int getIdClient() {
		return idClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Client [" + super.toString() + ", " + email + ", id = " + idClient + "]";
	}

}
