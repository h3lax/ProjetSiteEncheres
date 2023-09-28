package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import fr.eni.projet.encheres.modele.bo.Enchere;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

public class EnchereDAOImpl implements EnchereDAO {

	public int creerEnchere(Enchere enchere) {
		int modif = 0;
		try (Connection cnx = ConnectionProvider.getConnection()) {
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
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx
					.prepareStatement("SELECT TOP 1 * FROM ENCHERES WHERE no_article = ? ORDER BY date_enchere DESC");
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				enchere.setNoUtilisateur(rs.getInt(1));
				enchere.setNoArticle(rs.getInt(2));
				enchere.setDateEnchere(rs.getTimestamp(3).toLocalDateTime());
				enchere.setMontantEnchere(rs.getInt(4));
			} else
				enchere = null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchere;
	}

	public Enchere selectEnchereByCouple(int noUtilisateur, int noArticle) {
		Enchere enchere = new Enchere();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx
					.prepareStatement("SELECT * FROM ENCHERES WHERE no_utilisateur = ? and no_article = ?");
			stmt.setInt(1, noUtilisateur);
			stmt.setInt(2, noArticle);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				enchere.setNoUtilisateur(rs.getInt(1));
				enchere.setNoArticle(rs.getInt(2));
				enchere.setDateEnchere(rs.getTimestamp(3).toLocalDateTime());
				enchere.setMontantEnchere(rs.getInt(4));
			} else
				enchere = null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchere;
	}

	public int deleteEchere(int noUtilisateur, int noArticle) {
		int modif = 0;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx
					.prepareStatement("DELETE FROM Encheres WHERE no_utilisateur = ? and no_article = ?");
			stmt.setInt(1, noUtilisateur);
			stmt.setInt(2, noArticle);
			modif = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modif;
	}

public Utilisateur getUtilisateurGagnant(int noArticle) {
		Utilisateur utilisateurGagnant = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx
					.prepareStatement(					"SELECT U.* FROM Utilisateurs U " + "JOIN Encheres E ON U.no_utilisateur = E.no_utilisateur "
							+ "WHERE E.no_article = ? AND E.montant_enchere = (SELECT MAX(montant_enchere) FROM Encheres WHERE no_article = ?)");

			
			stmt.setInt(1, noArticle);
			stmt.setInt(2, noArticle);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				utilisateurGagnant = new Utilisateur();
				// Remplir l'objet Utilisateur avec les données du résultat de la requête
				utilisateurGagnant.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateurGagnant.setPseudo(rs.getString("pseudo"));
				utilisateurGagnant.setNom(rs.getString("nom"));
				utilisateurGagnant.setPrenom(rs.getString("prenom"));
				utilisateurGagnant.setEmail(rs.getString("email"));
				utilisateurGagnant.setTelephone(rs.getString("telephone"));
				utilisateurGagnant.setRue(rs.getString("rue"));
				utilisateurGagnant.setCodePostal(rs.getString("code_postal"));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return utilisateurGagnant;
	}
@Override
	public int getMontantMaximumEnchere(int noArticle) {
		int montantMaximum=0;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt=cnx.prepareStatement("SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article = ?"); 
			
			stmt.setInt(1, noArticle);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				montantMaximum=rs.getInt(1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return montantMaximum;
	}
@Override
	public boolean enregistrerEnchere(int noArticle, int noUtilisateur, int montantEnchere) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt=cnx.prepareStatement("INSERT INTO ENCHERES(no_utilisateur,no_article,montantEnchere)VALUES (?,?,?)");
			stmt.setInt(1,noUtilisateur);
			stmt.setInt(2, noArticle);
			stmt.setInt(3, montantEnchere);
			int rowAffected = stmt.executeUpdate();
			return rowAffected>0;
			
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}
}