package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import fr.eni.projet.encheres.modele.bo.Enchere;

public class EnchereDAOImpl implements EnchereDAO {

	public int creerEnchere(Enchere enchere) {
		int modif = 0;
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO Encheres values(?, ?, ?, ?)");
			
			stmt.setInt(1, enchere.getNoUtilisateur());
			stmt.setInt(2, enchere.getNoArticle());
			stmt.setTimestamp(3, Timestamp.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontantEnchere());
			modif = stmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modif;
	}

	public Enchere selectLastEnchere(int noArticle) {
		Enchere enchere = new Enchere();
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement("SELECT TOP 1 * FROM ENCHERES WHERE no_article = ? ORDER BY date_enchere DESC");
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				enchere.setNoUtilisateur(rs.getInt(1));
				enchere.setNoArticle(rs.getInt(2));
				enchere.setDateEnchere(rs.getTimestamp(3).toLocalDateTime());
				enchere.setMontantEnchere(rs.getInt(4));
			} else enchere = null;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enchere;
	}

	public Enchere selectEnchereByCouple(int noUtilisateur, int noArticle) {
		Enchere enchere = new Enchere();
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM ENCHERES WHERE no_utilisateur = ? and no_article = ?");
			stmt.setInt(1, noUtilisateur);
			stmt.setInt(2, noArticle);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				enchere.setNoUtilisateur(rs.getInt(1));
				enchere.setNoArticle(rs.getInt(2));
				enchere.setDateEnchere(rs.getTimestamp(3).toLocalDateTime());
				enchere.setMontantEnchere(rs.getInt(4));
			} else enchere = null;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enchere;
	}

	public int deleteEchere(int noUtilisateur, int noArticle) {
		int modif = 0;
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement("DELETE FROM Encheres WHERE no_utilisateur = ? and no_article = ?");
			stmt.setInt(1, noUtilisateur);
			stmt.setInt(2, noArticle);
			modif = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modif;
	}

	
	
	
}
