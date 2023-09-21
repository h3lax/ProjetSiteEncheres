package fr.eni.projet.encheres.modele.bll;

public class ArticleVenduManagerSing {
	public static ArticleVenduManager instance;
	
	public static ArticleVenduManager getInstance() {
		if (instance == null) {
			instance = new ArticleVenduManagerImpl();
		}
		return instance;
	}
}
