package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {
	
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, " +
		    "prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
		    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


	@Override
	public void insert(ArticleVendu articleVendu) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement(INSERT); // TODO : Gérer la récupération de l'identifiant
			stmt.setString(1, articleVendu.getNomArticle());
			stmt.setString(2, articleVendu.getDescription());
			
			// Convertir de LocalDateTime en Timestamp pour dateDebutEncheres
	        LocalDateTime dateDebut = articleVendu.getDateDebutEncheres();
	        stmt.setTimestamp(3, Timestamp.valueOf(dateDebut));

	        // Convertion de LocalDateTime en Timestamp pour dateFinEncheres
	        LocalDateTime dateFin = articleVendu.getDateFinEncheres();
	        stmt.setTimestamp(4, Timestamp.valueOf(dateFin));
			
			stmt.setInt(5, articleVendu.getPrixInitial());
			stmt.setInt(6, articleVendu.getPrixVente());
			stmt.setString(7, articleVendu.getEtatVente());
			stmt.setInt(8, articleVendu.getNoUtilisateur());
			stmt.setInt(9, articleVendu.getNoCategorie());
			
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			// TODO : faire la gestion des exceptions
		}
	}

}