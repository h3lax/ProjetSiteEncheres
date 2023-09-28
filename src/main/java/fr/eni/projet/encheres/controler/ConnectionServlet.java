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
		String rememberMe = request.getParameter("rememberMe");
	        
        if (rememberMe != null && rememberMe.equals("on")) {
        	//Création d'une session pour stocker les infos de l'utilisateur
        	HttpSession session = request.getSession(true);
            session.setAttribute("userLoggedIn", true);
            response.sendRedirect("accueil.jsp");
        } else {             
	        Utilisateur utilisateur = utilisateurManager.connection(identifiant, motDePasse);
	        if (utilisateur != null) {
	            HttpSession session = request.getSession();
	            
	            // Ajoutez la marque de temps actuelle à la session
	            session.setAttribute("lastActivityTime", System.currentTimeMillis());
	
	            // Définir un temps de session (par exemple, 5 minutes)
	            session.setMaxInactiveInterval(300); // en secondes
	
	            request.getSession().setAttribute("utilisateur", utilisateur);
	            this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	        } else {
	            String erreurID = "Identifiant ou mot de passe inconnu";
	            request.setAttribute("erreurID", erreurID);
	            this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
	            request.getRequestDispatcher("/c.jsp").forward(request, response);
	        }
	        
	        // Vérifiez si la session a expiré en raison de l'inactivité
	        HttpSession session = request.getSession(false);
	        if (session != null && session.getAttribute("utilisateur") == null) {
	            // L'utilisateur n'est pas connecté (session expirée)
	            response.sendRedirect("/deconnection.jsp"); // Redirection vers la page de déconnexion
	        }
        }
	}
}