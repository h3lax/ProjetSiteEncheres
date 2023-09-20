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

	public boolean verifConfirmation(String motDePasse, String confirmation) {
		if (motDePasse.equals(confirmation)) return true;
		else return false;
	}
	
	public boolean verifChampsVides(String pseudo, String nom, String prenom, String email,
			String rue, String codePostal, String ville, String motDePasse) {
		String[] champs = {pseudo, nom, email, rue, codePostal, ville, motDePasse};
		boolean validation = true;
		for (String s : champs) {
			if (s == null || s.isBlank() || s.isEmpty()) validation = false;
		}
		return validation;
	}
	
	public int verifNouvelUtilisateur(String pseudo, String email) {
		return utilisateurDAO.verifNouvelUtilisateur(pseudo, email);
	}
	
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		return utilisateurDAO.creerUtilisateur(utilisateur);
	}


}
