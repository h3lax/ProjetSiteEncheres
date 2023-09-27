package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface UtilisateurManager {

	boolean verifEstEgal(String motDePasse, String confirmation);

	boolean verifChampsRemplits(String s);
	boolean verifChampsRemplits(String pseudo, String nom, String prenom, String email, String rue, String codePostal, String ville, String motDePasse);
	
	int verifNouvelUtilisateur(String pseudo, String email);
	
	Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse);
	
	Utilisateur connection(String identifiant, String motDePasse);

	Utilisateur selectByIndentifiant(String identifiant);
	Utilisateur selectByIndentifiant(int identifiant);

	boolean modifierUtilisateur(Utilisateur utilisateur);

	boolean supprimerCompte(int noUtilisateur);

	boolean verifPoints(Utilisateur utilisateur, int montantEnchere);

	boolean paiement(Utilisateur utilisateur, int montantEnchere);

	boolean credit(Utilisateur utilisateur, int montantEnchere);
	boolean credit(int noUtilisateur, int montantEnchere);

}
