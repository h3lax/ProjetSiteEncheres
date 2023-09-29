package fr.eni.projet.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		 // Vérifier s'il y a un cookie "username"
        Cookie[] cookies = request.getCookies();
        String savedUsername = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("identifiant")) {
                    savedUsername = cookie.getValue();
                    break;
                }
            }
        }
        
        // Si un nom d'utilisateur est trouvé dans le cookie, authentifier automatiquement l'utilisateur
        if (savedUsername != null) {
            // Authentifier automatiquement l'utilisateur ici
	        Utilisateur utilisateur = utilisateurManager.selectByIndentifiant(savedUsername);
	        HttpSession session = request.getSession(true);
	        session.setAttribute("lastActivityTime", System.currentTimeMillis());
	        session.setMaxInactiveInterval(300); // en secondes
	        request.getSession().setAttribute("utilisateur", utilisateur);
            // Rediriger l'utilisateur vers la page d'accueil après l'authentification automatique
            response.sendRedirect("accueil");
        } else {
            // Afficher la page d'accueil normale
        	this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
        }
    
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("id");
		String motDePasse = request.getParameter("mdp");
		boolean rememberMe = request.getParameter("rememberMe") != null;
	        
                  
        Utilisateur utilisateur = utilisateurManager.connection(identifiant, motDePasse);
        if (utilisateur != null) {
            HttpSession session = request.getSession(true);
            
            // Ajoutez la marque de temps actuelle à la session
            session.setAttribute("lastActivityTime", System.currentTimeMillis());

            // Définir un temps de session (par exemple, 5 minutes)
            session.setMaxInactiveInterval(300); // en secondes
            
            //Gestion du remember me
            if (rememberMe) {
                Cookie cookie = new Cookie("identifiant", identifiant);
                cookie.setMaxAge(30 * 24 * 60 * 60); // Durée de vie du cookie en secondes (30 jours ici)
                response.addCookie(cookie);
            }
            // Rediriger l'utilisateur vers la page d'accueil
            request.getSession().setAttribute("utilisateur", utilisateur);
            this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
            
        } else {
            String erreurID = "Identifiant ou mot de passe inconnu";
            request.setAttribute("erreurID", erreurID);
            this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
	        
	        
	       
        }
	}
}