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
		request.getRequestDispatcher("/WEB-INF/article-vendu.jsp").forward(request, response);
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
		
		int prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
		
		// valeur par défaut
		int prixVente = 0; // TODO : à définir 
		
		// valeur par défaut
	    String etatVente = "En cours";
		
		int noCategorie = Integer.parseInt(request.getParameter("noCategorie"));
		int noUtilisateur = 2; // TODO: récupérer la valeur appropriée pour l'utilisateur depuis la session
		
		String message="";
		
		// traitement
		manager.addArticleVendu(new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, etatVente, noUtilisateur, noCategorie));
		message = "Insertion effectuée";
		
		// retour à la jsp
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/article-vendu.jsp").forward(request, response);
	}

}
