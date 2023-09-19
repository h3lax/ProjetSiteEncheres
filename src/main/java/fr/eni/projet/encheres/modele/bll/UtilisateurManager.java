package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface UtilisateurManager {

	boolean verifConfirmation(String motDePasse, String confirmation);

	Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse);
	

}
