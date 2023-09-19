package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;
import fr.eni.projet.encheres.modele.dal.DAOFactory;
import fr.eni.projet.encheres.modele.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager{
	
	private static UtilisateurManager utilisateurManager = null;
	private static UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	
	public static UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManagerImpl();
		}
		return utilisateurManager ;
	}
	
	private UtilisateurManagerImpl() {
	}

	@Override
	public boolean verifConfirmation(String motDePasse, String confirmation) {
		if (motDePasse.equals(confirmation)) return true;
		else return false;
	}
	
	@Override
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		utilisateurDAO.creerUtilisateur(utilisateur);
		
		return utilisateur;
	}

}
