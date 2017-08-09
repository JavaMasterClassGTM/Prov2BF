package vue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.CompteCourant;
import model.CompteEpargne;
import service.GestionClients;


/**
 * Servlet implementation class ControleurClient
 */
@WebServlet("/ControleurClient")
public class ControleurClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionClients gestionClients = new GestionClients();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurClient() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GestionClients gestionClients = new GestionClients();		
		RequestDispatcher rd = null;
		HttpSession hsession = request.getSession();
		
		String[] id = { request.getParameter("listeClients"), request.getParameter("modifClients"),
				request.getParameter("listeComptes"), request.getParameter("effectuerVirement"),
				request.getParameter("seDeconnecter"), request.getParameter("afficherClient"), 
				request.getParameter("submit2"), request.getParameter("submit") };
		String choix = null;
		int i = 0;
		while (null == choix) {
			choix = id[i];
			i++;
		}

		switch (choix) {
		case "1":
			rd = request.getRequestDispatcher("/WEB-INF/liste-clients.jsp");
			List<Client> listeClients = gestionClients.recupListeClients();
			hsession.setAttribute("Liste", listeClients);
			break;
			
		case "Validez":
			Client c1 = gestionClients.recupInfosClient(request.getParameter("nom"));
			hsession.setAttribute("Client", c1);
			rd = request.getRequestDispatcher("/WEB-INF/edit-client.jsp");
			break;
			
		case "Rechercher":
			Client c2 = gestionClients.recupInfosClient(request.getParameter("nom"));
			hsession.setAttribute("Client", c2);
			CompteCourant cc = gestionClients.recupInfosClientCC(request.getParameter("nom"));
			CompteEpargne ce = gestionClients.recupInfosClientCE(request.getParameter("nom"));
			hsession.setAttribute("cc", cc);
			hsession.setAttribute("ce", ce);
			rd = request.getRequestDispatcher("/WEB-INF/afficher-comptes.jsp");
			break;
			
		case "Validation":
			Client c = gestionClients.recupInfosClient(request.getParameter("nom"));
			hsession.setAttribute("Client", c);
			rd = request.getRequestDispatcher("/WEB-INF/afficher-client.jsp");
			break;
			
		case "3":
			rd = request.getRequestDispatcher("/WEB-INF/selection-client3.jsp");
			break;
			
		case "4":
			rd = request.getRequestDispatcher("/WEB-INF/donneesvirement.jsp");
			break;
			
		case "5":
			rd = request.getRequestDispatcher("/authentification.jsp");
			break;
		case "6":
			
			rd = request.getRequestDispatcher("/WEB-INF/selection-client2.jsp");
			break;
			
		case "8":
			rd = request.getRequestDispatcher("/WEB-INF/selection-client.jsp");
		break;
			
		case "Valider":
			rd = request.getRequestDispatcher("/WEB-INF/options.jsp");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String adresse = request.getParameter("adresse");
			String codePostal = request.getParameter("codepostal");
			String ville = request.getParameter("ville");
			gestionClients.updateClient(nom, prenom, email, adresse, codePostal, ville);
			break;
			
		case "Effectuer le virement":
			String debiteur = request.getParameter("debiteur");
			String crediteur = request.getParameter("crediteur");
			String montant = request.getParameter("montant");
			hsession.setAttribute("Débiteur", debiteur);
			hsession.setAttribute("Créditeur", crediteur);
			hsession.setAttribute("Montant", montant);
			gestionClients.Virement(Integer.parseInt(debiteur), Integer.parseInt(crediteur), Double.parseDouble(montant));
			rd = request.getRequestDispatcher("/WEB-INF/virement.jsp");
		default:
			break;
		}
		rd.forward(request, response);

	}
}