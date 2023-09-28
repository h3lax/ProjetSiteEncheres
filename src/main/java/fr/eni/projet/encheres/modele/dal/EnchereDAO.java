package fr.eni.projet.encheres.modele.dal;

import fr.eni.projet.encheres.modele.bo.Enchere;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface EnchereDAO {

	int creerEnchere(Enchere enchere);

	Enchere selectLastEnchere(int noArticle);

	Enchere selectEnchereByCouple(int noUtilisateur, int noArticle);

	int deleteEchere(int noUtilisateur, int noArticle);

	Utilisateur getUtilisateurGagnant(int noArticle);

	int getMontantMaximumEnchere(int noArticle);

	boolean enregistrerEnchere(int noArticle, int noUtilisateur, int montantEnchere);

}
