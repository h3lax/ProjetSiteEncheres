package fr.eni.projet.encheres.modele.bll;

import java.time.LocalDateTime;

import fr.eni.projet.encheres.modele.bo.Enchere;
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
	
	public Enchere creerEnchere(int noUtilisateur, int noArticle, int prixEnchere) {
		Enchere enchere = new Enchere(noUtilisateur, noArticle, prixEnchere);
		enchere.setDateEnchere(LocalDateTime.now());
		if (enchereDAO.creerEnchere(enchere) == 0) {
			enchere = null;
		}
		System.out.println(enchere);
		return enchere;
	}
	
	
}
