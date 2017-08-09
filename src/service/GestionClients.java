package service;

import java.util.List;

import dao.DaoClients;
import model.Client;
import model.CompteCourant;
import model.CompteEpargne;

/**
 *  Classe du package service qui permet de faire le lien avec le package dao
 * @author  Brice ADELIN / Francois DESTREMAU
 * @version v2
 *
 */
public class GestionClients {

	/**
	 * Méthode pqui retourne la liste des clients d'un conseiller
	 * @return Liste de clients
	 */
	public List<Client> recupListeClients() {
		List<Client> listeClients;
		DaoClients gererClients = new DaoClients();
		listeClients = gererClients.daoListeClients();
		return listeClients;
	}

	/**
	 * Méthode qui permet d'avoir accès aux informations d'un client à partir de son nom
	 * @param Nom d'un client
	 * @return Les informations du client accessible par l'objet client
	 */
	public Client recupInfosClient(String nom) {
		DaoClients gererClients = new DaoClients();
		Client client;
		client = gererClients.daoInfosClient(nom.trim());
		return client;
	}

	/**
	 * Méthode qui permet d'avoir accès aux informations du compte courant d'un client à partir de son nom
	 * @param Nom d'un client
	 * @return Les informations du compte courant d'un client accessible par l'objet infosClientCC de type CompteCourant  
	 */
	public CompteCourant recupInfosClientCC(String nom) {
		DaoClients gererClients = new DaoClients();
		CompteCourant infosClientCC;
		infosClientCC = gererClients.daoInfosClientCC(nom.trim());
		return infosClientCC;
	}

	/**
	 * Méthode qui permet d'avoir accès aux informations du compte épargne d'un client à partir de son nom
	 * @param Nom d'un client
	 * @return Les informations du compte épargne d'un client accessible par l'objet infosClientCE de type CompteEpargne  
	 */
	public CompteEpargne recupInfosClientCE(String nom) {
		DaoClients gererClients = new DaoClients();
		CompteEpargne infosClientCE;
		infosClientCE = gererClients.daoInfosClientCE(nom.trim());
		return infosClientCE;
	}

	/**
	 * Méthode qui eprmet de mettre à jour les informations d'un client à partir du nom du client
	 * @param nom du client
	 * @param prenom du client
	 * @param email du client
	 * @param adresse du client 
	 * @param codePostal du client
	 * @param ville du client
	 */
	public void updateClient(String nom, String prenom, String email, String adresse, String codePostal, String ville) {
		DaoClients gererClients = new DaoClients();
		gererClients.daoMiseAJourClient(nom.trim(), prenom.trim(), email.trim(), adresse.trim(), codePostal.trim(),
				ville.trim());
	}

	/**
	 * Méthode pour effectuer un virement entre deux comptes
	 * @param numeroCompteDebiteur
	 * @param numeroCompteCrediteur
	 * @param montantVirement
	 */
	public void Virement(int numeroCompteDebiteur, int numeroCompteCrediteur, double montantVirement) {
		DaoClients gererClients = new DaoClients();
		double soldeCompteDebiteur = 0.0;
		double soldeCompteCrediteur = 0.0;
		double nouveauSoldeCompteDebiteur = 0.0;
		double nouveauSoldeCompteCrediteur = 0.0;

		if (numeroCompteDebiteur % 2 == 0) {
			soldeCompteDebiteur = gererClients.daoSoldeCompteCourant(numeroCompteDebiteur);
		} else if (numeroCompteDebiteur % 2 == 1) {
			soldeCompteDebiteur = gererClients.daoSoldeCompteEpargne(numeroCompteDebiteur);
		}

		if (numeroCompteCrediteur % 2 == 0) {
			soldeCompteCrediteur = gererClients.daoSoldeCompteCourant(numeroCompteCrediteur);
		} else if (numeroCompteCrediteur % 2 == 1) {
			soldeCompteCrediteur = gererClients.daoSoldeCompteEpargne(numeroCompteCrediteur);
		}

		nouveauSoldeCompteDebiteur = soldeCompteDebiteur - montantVirement;
		nouveauSoldeCompteCrediteur = soldeCompteCrediteur + montantVirement;

		if (numeroCompteDebiteur % 2 == 0) {
			gererClients.daoNouveauSoldeCompteCourant(numeroCompteDebiteur, nouveauSoldeCompteDebiteur);
		}
		if (numeroCompteDebiteur % 2 == 1) {
			gererClients.daoNouveauSoldeCompteEpargne(numeroCompteDebiteur, nouveauSoldeCompteDebiteur);
		}

		if (numeroCompteCrediteur % 2 == 0) {
			gererClients.daoNouveauSoldeCompteCourant(numeroCompteCrediteur, nouveauSoldeCompteCrediteur);
		}
		if (numeroCompteCrediteur % 2 == 1) {
			gererClients.daoNouveauSoldeCompteEpargne(numeroCompteCrediteur, nouveauSoldeCompteCrediteur);
		}
	}
}