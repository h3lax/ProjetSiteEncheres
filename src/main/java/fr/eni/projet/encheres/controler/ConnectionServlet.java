package fr.eni.projet.encheres.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bll.UtilisateurManager;
import fr.eni.projet.encheres.modele.bll.UtilisateurManagerImpl;
import fr.eni.projet.encheres.modele.bo.Utilisateur;
/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String identifiant = request.getParameter("id");
		String motDePasse = request.getParameter("mdp");
		
		//on fait appel à la BLL pour savoir si l'utilisateur est enregistré: 
		// si oui, un Utilisateur est renvoyé. On le récupère et le transmet dans la requete avant de rediriger vers la servlet d'accueil
		// sinon on renvoit à la page de connexion (il est possible que l'utilisateur ait fait une erreur de frappe?
		Utilisateur utilisateur = utilisateurManager.connection(identifiant, motDePasse);
		if (utilisateur != null) {
			request.getSession().setAttribute("utilisateur",utilisateur);
			this.getServletContext().getRequestDispatcher("/acceuil.jsp").forward(request, response);
		}else {
			String erreurID = "Identifiant ou mot de passe inconnu";
			request.setAttribute("erreurID", erreurID);
			this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
		}

		

	}
}
