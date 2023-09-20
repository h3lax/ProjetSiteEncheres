package fr.eni.projet.encheres.modele.dal;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur creerUtilisateur(Utilisateur utilisateur);

	int verifNouvelUtilisateur(String pseudo, String email);

}
