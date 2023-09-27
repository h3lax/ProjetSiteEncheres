package fr.eni.projet.encheres.modele.dal;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOImpl();
	}

	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
}
