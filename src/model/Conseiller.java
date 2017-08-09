package model;

/**
 * Objet métier : Javabean Conseiller
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 */
public class Conseiller extends Personne {

	private String login;
	private String password;
	private int idConseiller;

	public Conseiller(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

}
