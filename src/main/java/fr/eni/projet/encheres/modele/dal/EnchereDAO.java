package fr.eni.projet.encheres.modele.dal;

import fr.eni.projet.encheres.modele.bo.Enchere;

public interface EnchereDAO {

	int creerEnchere(Enchere enchere);

	Enchere selectLastEnchere(int noArticle);

	Enchere selectEnchereByCouple(int noUtilisateur, int noArticle);

	int deleteEchere(int noUtilisateur, int noArticle);

}
