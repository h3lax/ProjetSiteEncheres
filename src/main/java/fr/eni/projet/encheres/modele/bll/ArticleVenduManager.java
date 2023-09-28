package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;

public interface ArticleVenduManager {
	
	public void addArticleVendu(ArticleVendu articleVendu);

	public boolean updatePrixVente(ArticleVendu articleVendu, int montantEnchere);

	public ArticleVendu selectById(int idArticle);
	
}
