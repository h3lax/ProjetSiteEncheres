package fr.eni.projet.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bll.EnchereManager;
import fr.eni.projet.encheres.modele.bll.EnchereManagerImpl;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/encherir")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager enchereManager = EnchereManagerImpl.getInstance();   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Trouver le moyen de récupérer le noArticle j'imagine qu'on va devoir le glisser dans la requete
		//Il me faut l'objet Article en fait
//		int noArticle = Integer.parseInt(request.getParameter("noArticle"));
//		
//		int prixEnchere = Integer.parseInt(request.getParameter("prixEnchere"));
//		
//		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
//		int noUtilisateur = utilisateur.getNoUtilisateur();
		
		
		//TEST
		int noArticle = 2;
		int prixEnchere = 150;
		int noUtilisateur = 1;
		//je demande à la BLL de me créer l'enchere en BD et en métier
		enchereManager.creerEnchere(noUtilisateur, noArticle, prixEnchere);
		
		
		
		this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		
		
		
	}

}
