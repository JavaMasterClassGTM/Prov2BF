package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.ControleurLogin;

/**
 * Classe qui permet de gérer les connexions et déconnexions
 * @author Brice ADELIN / Francois DESTREMAU
 * @version v2
 */

public class Bdd {
	private static String URL = "jdbc:mysql://localhost/bd";
	private static String user = "root";
	private static String password = "";

	/**
	 * Permet de se connecter automatiquement avec les attributs de classe données
	 * dans la classe
	 */
	public static Connection seconnecter() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			Connection c = DriverManager.getConnection(URL, user, password);
			return c;
		} catch (SQLException ex) {
			Logger.getLogger(ControleurLogin.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}

	}

	/**
	 *  Permet de se déconnecter 
	 */
	public static void sedeconnecter(Connection c) {
		try {
			c.close();
		} catch (SQLException ex) {
			Logger.getLogger(ControleurLogin.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
