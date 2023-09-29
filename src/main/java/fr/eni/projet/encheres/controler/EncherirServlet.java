package fr.eni.projet.encheres.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bll.ArticleVenduManager;
import fr.eni.projet.encheres.modele.bll.ArticleVenduManagerSing;
import fr.eni.projet.encheres.modele.bll.EnchereManager;
import fr.eni.projet.encheres.modele.bll.EnchereManagerImpl;
import fr.eni.projet.encheres.modele.bll.UtilisateurManager;
import fr.eni.projet.encheres.modele.bll.UtilisateurManagerImpl;
import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.bo.Enchere;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/detail-article")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager enchereManager = EnchereManagerImpl.getInstance();
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
	private ArticleVenduManager articleVenduManager = ArticleVenduManagerSing.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noArticle = Integer.parseInt(request.getParameter("noArticle"));
		ArticleVendu articleVendu = articleVenduManager.selectById(noArticle);
		Utilisateur vendeur = utilisateurManager.selectByIndentifiant(articleVendu.getNoUtilisateur());
		request.setAttribute("article", articleVendu);
		request.setAttribute("vendeur", vendeur);
		this.getServletContext().getRequestDispatcher("/detail-article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Je récupère un l'identifiant de l'article depuis la requête http
		int idArticle = Integer.parseInt(request.getParameter("noArticle"));
		ArticleVendu articleVendu = articleVenduManager.selectById(idArticle);
		
		//Je récupère l'utilisateur en session
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		//Récupération des paramètres pour créer l'enchère
		int montantEnchere = Integer.parseInt(request.getParameter("prixEnchere"));
		
		//Nous faisons en sorte, dans le cycle de vie de l'article d'actualiser le prix de vente systématiquement pour éviter de devoir faire des requêtes inutiles en BD
		//Logiquement le prix de vente est égal soit au prix initial soit au prix de la dernière enchère qui est nécéssairement la plus haute.
		String message = null;
		if (!enchereManager.verifPrixSuperieur(montantEnchere, articleVendu.getPrixVente())) {
			message = "Vous devez indiquer un prix supérieur au prix de vente actuel pour valider votre enchère";
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/detail-article.jsp").forward(request, response); //Rajouter le message d'erreur quand la page sera faite
		}
		
		//il me faut une fonction pour retirer les points de l'utilisateur qui enchérit
		//Dabord je vérifie que le montant de l'enchère est supérieure aux points dont l'utilisateur est en possession
		else if (!utilisateurManager.verifPoints(utilisateur, montantEnchere)) {
			message = "Désolé, mais vous n'avez pas suffisement de crédit pour placer cette enchère";
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/detail-article.jsp").forward(request, response); //Rajouter le message d'erreur quand la page sera faite
		} else {
			//Je vais chercher l'enchère précédente AVANT d'avoir créé mon enchère couillon!
			Enchere ancienneEnchere = enchereManager.verifEnchereExistante(articleVendu);
			//Ensuite je crée l'enchère en BD
			//Attention, si l'utilisateur a déjà enchéri il faut supprimer son ancienne enchère avant car le couple noarticle et noUser est unique
			//Pour pouvoir en créer une nouvelle ensuite creer enchère gère tout d'un coup
			if(enchereManager.creerEnchere(utilisateur, articleVendu, montantEnchere) != null) {
				//Si c'est bon, je modifie alors les crédits de l'utilisateur & j'actualise le prixVente de l'article
				utilisateurManager.paiement(utilisateur, montantEnchere);
				//On oublie pas de modifier le prix de vente de l'article pour qu'il soit à jour
				articleVenduManager.updatePrixVente(articleVendu, montantEnchere);
				//Je vais chercher l'enchère précédente que j'ai mémorisé, s'il y en a une et je rembourse l'ancien enchereur
				if (ancienneEnchere != null) utilisateurManager.credit(ancienneEnchere.getNoUtilisateur(), ancienneEnchere.getMontantEnchere());
				this.getServletContext().getRequestDispatcher("/testEnchere.jsp").forward(request, response);
			} else {
				message = "Nous avons rencontré un problème lors de la création de votre enchère";
				request.setAttribute("message", message);
				this.getServletContext().getRequestDispatcher("/detail-article.jsp").forward(request, response);
			}
		}
	}

}
