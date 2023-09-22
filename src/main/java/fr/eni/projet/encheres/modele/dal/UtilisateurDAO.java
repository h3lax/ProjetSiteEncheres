package fr.eni.projet.encheres.modele.dal;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur creerUtilisateur(Utilisateur utilisateur);

	Utilisateur selectByIdentifiant(String pseudo, String email);
	Utilisateur selectByIdentifiant(String identifiant);
	
	Utilisateur connection(String identifiant, String motDePasse);

	int modifierUtilisateur(Utilisateur utilisateur);

}
