package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.bo.Enchere;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

public interface EnchereManager {

	Enchere creerEnchere(Utilisateur utilisateur, ArticleVendu articleVendu, int prixEnchere);

	boolean verifPrixSuperieur(int prixEnchere, int prixVente);

	Enchere verifEnchereExistante(ArticleVendu articleVendu);

	boolean verifAncienneEnchere(Utilisateur utilisateur, ArticleVendu articleVendu);

	boolean deleteEnchere(Utilisateur utilisateur, ArticleVendu articleVendu);

}
