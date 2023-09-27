package fr.eni.projet.encheres.modele.bll;

import java.time.LocalDateTime;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.bo.Enchere;
import fr.eni.projet.encheres.modele.bo.Utilisateur;
import fr.eni.projet.encheres.modele.dal.DAOFactory;
import fr.eni.projet.encheres.modele.dal.EnchereDAO;

public class EnchereManagerImpl implements EnchereManager{

	private static EnchereManager enchereManager = null;
	private static EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
	
	public static EnchereManager getInstance() {
		if (enchereManager == null) {
			enchereManager = new EnchereManagerImpl();
		}
		return enchereManager ;
	}
	
	private EnchereManagerImpl() {
		
	}
	
	
	public Enchere creerEnchere(Utilisateur utilisateur, ArticleVendu articleVendu, int prixEnchere) {
		boolean pasDeProblemes = true;
		//Attention, si l'utilisateur a déjà enchéri il faut supprimer son ancienne enchère avant car le couple noarticle et noUser est unique
		if(enchereManager.verifAncienneEnchere(utilisateur, articleVendu)) {
			if(!enchereManager.deleteEnchere(utilisateur, articleVendu)) pasDeProblemes = false;
		}
		System.out.println(pasDeProblemes);
		//Je crée l'enchère en BD
		Enchere enchere = new Enchere(utilisateur.getNoUtilisateur(), articleVendu.getNoArticle(), prixEnchere);
		enchere.setDateEnchere(LocalDateTime.now());
		if (enchereDAO.creerEnchere(enchere) == 0) {
			enchere = null;
		}
		System.out.println(enchere);
		return enchere;
	}

	public boolean verifPrixSuperieur(int montantEnchere, int prixVente) {
		if (montantEnchere > prixVente) return true;
		else return false;		
	}

	public Enchere verifEnchereExistante(ArticleVendu articleVendu) {
		Enchere derniereEnchere = null;
		if (articleVendu.getPrixVente() > articleVendu.getPrixInitial()) {
			derniereEnchere = enchereDAO.selectLastEnchere(articleVendu.getNoArticle());
		}
		return derniereEnchere;
		
	}

	public boolean verifAncienneEnchere(Utilisateur utilisateur, ArticleVendu articleVendu) {
		if (enchereDAO.selectEnchereByCouple(utilisateur.getNoUtilisateur(), articleVendu.getNoArticle()) != null) return true;
		else return false;
	}

	public boolean deleteEnchere(Utilisateur utilisateur, ArticleVendu articleVendu) {
		if (enchereDAO.deleteEchere(utilisateur.getNoUtilisateur(), articleVendu.getNoArticle()) == 1) return true;
		else return false;
	}
	
	
	
}
