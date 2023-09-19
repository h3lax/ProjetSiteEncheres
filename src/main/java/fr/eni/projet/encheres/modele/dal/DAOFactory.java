package fr.eni.projet.encheres.modele.dal;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

}
