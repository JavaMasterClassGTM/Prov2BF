package vue;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import service.GestionClients;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/ControleurLogin")
public class ControleurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurLogin() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		RequestDispatcher rd = null;
		
		if ("yann".equalsIgnoreCase(login) && "jee".equalsIgnoreCase(pwd)) {
			rd = request.getRequestDispatcher("/WEB-INF/options.jsp");
		}

		else {
			rd = request.getRequestDispatcher("/WEB-INF/failed-authentification.jsp");
		}
		rd.forward(request, response);
	}

}
