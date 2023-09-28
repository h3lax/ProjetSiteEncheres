package fr.eni.projet.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.eni.projet.encheres.modele.bll.UtilisateurManager;
import fr.eni.projet.encheres.modele.bll.UtilisateurManagerImpl;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("id");
		String motDePasse = request.getParameter("mdp");

		// Récupérez la session actuelle de l'utilisateur
		HttpSession session = request.getSession(true);

		Utilisateur utilisateur = utilisateurManager.connection(identifiant, motDePasse);
		if (utilisateur != null) {
			// Ajoutez la marque de temps actuelle à la session
			session.setAttribute("lastActivityTime", System.currentTimeMillis());

			// Définir un temps de session en secondes

			session.setMaxInactiveInterval(300);
			request.getSession().setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		} else {
			String erreurID = "Identifiant ou mot de passe inconnu";
			request.setAttribute("erreurID", erreurID);
			this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
		}
	}
}
