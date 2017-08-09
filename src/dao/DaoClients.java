package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Client;
import model.CompteCourant;
import model.CompteEpargne;


/**
 * 
 * Classe du package dao (= persistance) qui permet de réaliser les méthodes du CRUD = Create Read Update Delete sur le base de données de l'application  
 * @author  Brice ADELIN / Francois DESTREMAU
 * @version v2
 *
 */
public class DaoClients {

	/**
	 * Permet à partir de l'identifiant du conseiller d'obtenir la liste de tous les clients du conseiller
	 * @return Liste des clients du conseiller
	 */
	public List<Client> daoListeClients() {
		List<Client> listeClients = new ArrayList<Client>();

		Connection connexion = Bdd.seconnecter();
		String sql = "Select idclient, idcc, idce, nom, prenom, email, adresse, codepostal, ville from client where idconseiller=?";
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setInt(1, 1);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				String codePostal = rs.getString("codepostal");
				String ville = rs.getString("ville");
				int idclient = rs.getInt("idclient");
				int idcc=rs.getInt("idcc");
				int idce=rs.getInt("idce");
				Client client = new Client(nom, prenom, email, adresse, codePostal, ville, idclient, idcc, idce);
				listeClients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Bdd.sedeconnecter(connexion);
		return listeClients;
	};
	
	
	/**
	 * Permet à partir du nom d'un client de récupérer ses informations (son nom, son prénom, son email, son adresse, son code postal et sa ville) de la base de données
	 */
	public Client daoInfosClient(String nom) {
		Client client = new Client();
		
		Connection connexion = Bdd.seconnecter();
		String sql = "Select idclient, prenom, email, adresse, codepostal, ville "
				+ " from client "
				+ " where upper(nom)=upper(?)";
		
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setString(1, nom);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				int idClient = rs.getInt("idclient");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				String codePostal = rs.getString("codepostal");
				String ville = rs.getString("ville");
			
				client = new Client(nom, prenom, email, adresse, codePostal, ville, idClient);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Bdd.sedeconnecter(connexion);
		return client;
	}
	
	/**
	 *
	 * Permet à partir du nom d'un client de récupérer ses informations de compte courant (solde, date d'ouverture et valeur de l'autorisation de découvert) de la base de données
	 * 
	 */
	public CompteCourant daoInfosClientCC (String nom) {
		CompteCourant compteCourantClient = new CompteCourant();
		
		Connection connexion = Bdd.seconnecter();
		String sql = "Select idcc, soldecc, autorisationdecouvert, dateouverturecc "
				+ " from client "
				+ " where upper(nom)=upper(?)";
		
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setString(1, nom);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				int idCC = rs.getInt("idcc");
				double soldeCC = rs.getDouble("soldecc");
				double autorisationDecouvert = rs.getDouble("autorisationdecouvert");
				Date dateOuvertureCC = rs.getDate("dateouverturecc");
				
				compteCourantClient = new CompteCourant(soldeCC, dateOuvertureCC, autorisationDecouvert, idCC);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Bdd.sedeconnecter(connexion);
		return compteCourantClient;
	}
	
	
	/**
	 *
	 * Permet à partir du nom d'un client de récupérer ses informations de compte épargne (solde, date d'ouverture et valeur de son taux de rémunération) de la base de données
	 * 
	 */
	public CompteEpargne daoInfosClientCE (String nom) {
		CompteEpargne compteEpargneClient = new CompteEpargne();
		
		Connection connexion = Bdd.seconnecter();
		String sql = "Select idce, soldece, tauxremun, dateouverturece "
				+ " from client "
				+ " where upper(nom)=upper(?)";
		
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setString(1, nom);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				int idCE = rs.getInt("idce");
				double soldeCE = rs.getDouble("soldece");
				double tauxRemun = rs.getDouble("tauxremun");
				Date dateOuvertureCE = rs.getDate("dateouverturece");
				
				compteEpargneClient = new CompteEpargne(soldeCE, dateOuvertureCE, tauxRemun, idCE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Bdd.sedeconnecter(connexion);
		return compteEpargneClient;
	}

	/**
	 * Permet à partir du nom d'un client, de mettre à jour ses informations (son prénom, son email, son adresse, son code postal et sa ville) dans la base de données
	 */
	public void daoMiseAJourClient(String nom, String prenom, String email, String adresse, String codePostal, String ville) {
		Connection connexion = Bdd.seconnecter();
		String sql = "update client "
				+ " set prenom = ?, "
				+ " email = ?, "
				+ " adresse = ?, "
				+ " codepostal = ?, "
				+ " ville = ? "
				+ " where upper(nom) = upper(?)";
		
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setString(1, prenom);
			pstat.setString(2, email);
			pstat.setString(3, adresse);
			pstat.setString(4, codePostal);
			pstat.setString(5, ville);
			pstat.setString(6, nom);
			pstat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Bdd.sedeconnecter(connexion);	
	}
	
	/**
	 * Permet à partir du numéro de compte d'un compte courant, de retourner la solde du compte
	 */
	public double daoSoldeCompteCourant(int numeroCompteCourant) {
		double soldeCompteCourant = 0.0;
		Connection connexion = Bdd.seconnecter();
		String sql = "select soldecc "
				+ " from client "
				+ " where idcc=?";
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setInt(1, numeroCompteCourant);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				soldeCompteCourant = rs.getDouble("soldecc");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Bdd.sedeconnecter(connexion);
		return soldeCompteCourant;
	}
	
	
	/**
	 * Permet à partir du numéro de compte d'un compte épargne, de retourner la solde du compte
	 */
	public double daoSoldeCompteEpargne(int numeroCompteEpargne) {
		double soldeCompteEpargne = 0.0;
		Connection connexion = Bdd.seconnecter();
		String sql = "select soldece "
				+ " from client "
				+ " where idce=?";
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setInt(1, numeroCompteEpargne);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				soldeCompteEpargne = rs.getDouble("soldece");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Bdd.sedeconnecter(connexion);
		return soldeCompteEpargne;
	}
	
	
	/**
	 * Permet à partir du numéro de compte d'un compte courant et de la solde, de mettre à jour dans la base de données le compte courant correspondant
	 */
	public void daoNouveauSoldeCompteCourant(int numeroCompteCourant, double nouveauSoldeCompteCourant) {
		Connection connexion = Bdd.seconnecter();
		String sql = "update client "
				+ " set soldecc = ? "
				+ " where idcc = ?";
		
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setDouble(1, nouveauSoldeCompteCourant);
			pstat.setDouble(2, numeroCompteCourant);
			pstat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Bdd.sedeconnecter(connexion);	
	}
	
	
	/**
	 * Permet à partir du numéro de compte d'un compte épargne et de la solde, de mettre à jour dans la base de données le compte épargne correspondant
	 */
	public void daoNouveauSoldeCompteEpargne(int numeroCompteEpargne, double nouveauSoldeCompteEpargne) {
		Connection connexion = Bdd.seconnecter();
		String sql = "update client "
				+ " set soldece = ? "
				+ " where idce = ?";
		
		try {
			PreparedStatement pstat = connexion.prepareStatement(sql);
			pstat.setDouble(1, nouveauSoldeCompteEpargne);
			pstat.setDouble(2, numeroCompteEpargne);
			pstat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Bdd.sedeconnecter(connexion);	
	}
}
	
	