package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Enchere;

public interface EnchereManager {

	Enchere creerEnchere(int noArticle, int noUtilisateur, int prixEnchere);

}
