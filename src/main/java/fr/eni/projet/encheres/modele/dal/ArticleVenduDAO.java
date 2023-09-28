package fr.eni.projet.encheres.modele.dal;

import java.util.List;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;

public interface ArticleVenduDAO {
	public int insert(ArticleVendu articleVendu);
	
	public List<ArticleVendu> listerEncheresEnCours();

	public int update(ArticleVendu articleVendu);

	public ArticleVendu selectById(int idArticle);

}
