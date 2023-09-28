package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.dal.ArticleVenduDAO;
import fr.eni.projet.encheres.modele.dal.DAOFactory;

public class ArticleVenduManagerImpl implements ArticleVenduManager {
	private ArticleVenduDAO dao = DAOFactory.getArticleVenduDAO();
	
	@Override
	public void addArticleVendu(ArticleVendu articleVendu) {
	    int generatedId = dao.insert(articleVendu);
	    articleVendu.setNoArticle(generatedId);
	}

	@Override
	public boolean updatePrixVente(ArticleVendu articleVendu, int montantEnchere) {
		articleVendu.setPrixVente(montantEnchere);
		if(dao.update(articleVendu) == 1 ) return true;
		else return false;
	}

	@Override
	public ArticleVendu selectById(int idArticle) {
		return dao.selectById(idArticle);
	}

}
