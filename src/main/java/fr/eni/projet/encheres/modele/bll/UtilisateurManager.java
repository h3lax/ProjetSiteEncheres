package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface UtilisateurManager {

	boolean verifEstEgal(String motDePasse, String confirmation);

	public boolean verifChampsRemplits(String s);
	boolean verifChampsRemplits(String pseudo, String nom, String prenom, String email,
			String rue, String codePostal, String ville, String motDePasse);
	
	int verifNouvelUtilisateur(String pseudo, String email);
	
	Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse);
	
	Utilisateur connection(String identifiant, String motDePasse);

	Utilisateur selectByIndentifiant(String identifiant);

	boolean modifierUtilisateur(Utilisateur utilisateur);

	boolean supprimerCompte(int noUtilisateur);


	

}
