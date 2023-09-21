package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.dal.ArticleVenduDAO;
import fr.eni.projet.encheres.modele.dal.DAOFactory;

public class ArticleVenduManagerImpl implements ArticleVenduManager {
	private ArticleVenduDAO dao = DAOFactory.getArticleVenduDAO();
	
	@Override
	public void addArticleVendu(ArticleVendu articleVendu) {
		dao.insert(articleVendu);
	}

}
