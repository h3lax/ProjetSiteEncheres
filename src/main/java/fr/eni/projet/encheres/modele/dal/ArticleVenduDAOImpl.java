package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {
	
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, " +
		    "prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
		    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


	@Override
	public int insert(ArticleVendu articleVendu) {
		int generatedKey = -1; 
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS); // TODO : Gérer la récupération de l'identifiant
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
			
			// récupération de la clé générée
	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            generatedKey = rs.getInt(1);
	        }
	        rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			// TODO : faire la gestion des exceptions
		}
		
		return generatedKey;
	}
	
	
	@Override
	public List<ArticleVendu> listerEncheresEnCours() {
	    List<ArticleVendu> encheresEnCours = new ArrayList<>();
	    
	    final String LISTER_ENCHERES_EN_COURS = "SELECT ARTICLES_VENDUS.*, UTILISATEURS.pseudo " + 
								                "FROM ARTICLES_VENDUS " + 
								                "JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur " +
								                "WHERE date_fin_encheres > GETDATE() AND etat_vente = 'En cours'";


	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        PreparedStatement stmt = cnx.prepareStatement(LISTER_ENCHERES_EN_COURS);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            ArticleVendu enchere = new ArticleVendu();
	            enchere.setNomArticle(rs.getString("nom_article"));
	            enchere.setDescription(rs.getString("description"));
	            enchere.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
	            enchere.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
	            enchere.setPrixInitial(rs.getInt("prix_initial"));
	            enchere.setPrixVente(rs.getInt("prix_vente"));
	            enchere.setEtatVente(rs.getString("etat_vente"));
	            enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
	            enchere.setNoCategorie(rs.getInt("no_categorie"));
	            enchere.setPseudoVendeur(rs.getString("pseudo"));
	            encheresEnCours.add(enchere);
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // TODO : gérer les exceptions
	    }

	    return encheresEnCours;
	}


	@Override
	public int update(ArticleVendu articleVendu) {
		int ligneModifie = 0;
		try (Connection cnx = ConnectionProvider.getConnection()){
			String requete = "UPDATE Articles_vendus SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, etat_vente = ?, no_categorie = ? WHERE no_article = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setString(1, articleVendu.getNomArticle());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setTimestamp(3, Timestamp.valueOf(articleVendu.getDateDebutEncheres()));
			pstmt.setTimestamp(4, Timestamp.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(5, articleVendu.getPrixInitial());
			pstmt.setInt(6, articleVendu.getPrixVente());
			pstmt.setString(7, articleVendu.getEtatVente());
			pstmt.setInt(8, articleVendu.getNoCategorie());
			pstmt.setInt(9, articleVendu.getNoArticle());
			ligneModifie = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligneModifie;
	}


	@Override
	public ArticleVendu selectById(int idArticle) {
		ArticleVendu enchere = new ArticleVendu();
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM Articles_vendus WHERE no_article = ?");
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setNomArticle(rs.getString("nom_article"));
	            enchere.setDescription(rs.getString("description"));
	            enchere.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
	            enchere.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
	            enchere.setPrixInitial(rs.getInt("prix_initial"));
	            enchere.setPrixVente(rs.getInt("prix_vente"));
	            enchere.setEtatVente(rs.getString("etat_vente"));
	            enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
	            enchere.setNoCategorie(rs.getInt("no_categorie"));
			} else enchere = null;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enchere;
	}

}
