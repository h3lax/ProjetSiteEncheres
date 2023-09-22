package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface UtilisateurManager {

	boolean verifConfirmation(String motDePasse, String confirmation);

	boolean verifChampsVides(String pseudo, String nom, String prenom, String email,
			String rue, String codePostal, String ville, String motDePasse);
	
	int verifNouvelUtilisateur(String pseudo, String email);
	
	Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse);
	
	public Utilisateur connection(String identifiant, String motDePasse);

	void deleteByEmail(String email, String motDePasse);
	

}
