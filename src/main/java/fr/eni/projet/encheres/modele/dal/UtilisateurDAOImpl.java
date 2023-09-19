package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			System.out.println("je suis-je connecté?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}

}
