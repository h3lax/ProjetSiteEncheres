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
import fr.eni.projet.encheres.modele.bo.Retrait;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

import fr.eni.projet.encheres.modele.dal.RetraitDAO;
import fr.eni.projet.encheres.modele.dal.RetraitDAOImpl;

/**
 * Servlet implementation class ArticleVenduServlet
 */
@WebServlet("/article-vendu")
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
		int prixVente = prixInitial ;
		
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
		ArticleVendu nouvelArticle = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, etatVente, noUtilisateur, noCategorie);
		manager.addArticleVendu(nouvelArticle);
		message = "Insertion effectuée";
		
		// récupération de l'id du nouvel article créé
		int nouvelArticleId = nouvelArticle.getNoArticle();
		
		// création du retrait
		Retrait retrait = new Retrait();
		retrait.setNoArticle(nouvelArticleId);
		retrait.setRue(utilisateur.getRue());
		retrait.setCodePostal(utilisateur.getCodePostal());
		retrait.setVille(utilisateur.getVille());

		// insertion du retrait en base de données
		RetraitDAO retraitDAO = new RetraitDAOImpl();
		retraitDAO.insert(retrait);
		
		// retour à la jsp
		request.setAttribute("message", message);
		request.getRequestDispatcher("/article-vendu.jsp").forward(request, response);
	}

}
