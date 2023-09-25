package fr.eni.projet.encheres.controler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bll.ArticleVenduManager;
import fr.eni.projet.encheres.modele.bll.ArticleVenduManagerSing;
import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

/**
 * Servlet implementation class ArticleVenduServlet
 */
@WebServlet("/ArticleVenduServlet")
public class ArticleVenduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager manager = ArticleVenduManagerSing.getInstance();
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/article-vendu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupération des données
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		
		String dateDebutEncheresString = request.getParameter("dateDebutEncheres");
		String dateFinEncheresString = request.getParameter("dateFinEncheres");
		LocalDateTime dateDebutEncheres = LocalDateTime.parse(dateDebutEncheresString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		LocalDateTime dateFinEncheres = LocalDateTime.parse(dateFinEncheresString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		// récupération de l'utilisateur depuis la session
	    Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
		int prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
		
		// valeur par défaut
		int prixVente = 0; // TODO : à définir 
		
		// valeur par défaut
	    String etatVente = "En cours";
		
		int noCategorie = Integer.parseInt(request.getParameter("noCategorie"));
		
	    if(utilisateur == null) {
	        // si l'utilisateur n'est pas connecté, redirection vers la page de connection
	    	request.getRequestDispatcher("/connection.jsp").forward(request, response);
	        return;
	    }
		
	    int noUtilisateur = utilisateur.getNoUtilisateur();
		
		String message="";
		
		// traitement
		manager.addArticleVendu(new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, etatVente, noUtilisateur, noCategorie));
		message = "Insertion effectuée";
		
		// retour à la jsp
		request.setAttribute("message", message);
		request.getRequestDispatcher("/article-vendu.jsp").forward(request, response);
	}

}
