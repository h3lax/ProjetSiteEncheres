package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.encheres.modele.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO UTILISATEURS values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	public Utilisateur selectByIdentifiant(String pseudo, String email) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE pseudo = ? or email = ?");
			stmt.setString(1, pseudo);
			stmt.setString(2, email);
			ResultSet rs = stmt.executeQuery();

			utilisateur = getUtilisateur(utilisateur, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public Utilisateur selectByIdentifiant(String identifiant) {
		return selectByIdentifiant(identifiant, identifiant);
	}

	public Utilisateur connection(String identifiant, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// On fait un select avec soit le pseudo soit l'identifiant MAIS AUSSI AVEC le
			// bon mdp
			PreparedStatement pstmt = cnx.prepareStatement(
					"SELECT * FROM utilisateurs WHERE (pseudo = ? OR email = ?)  AND mot_de_passe=? ");
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			pstmt.setString(3, motDePasse);
			ResultSet rs = pstmt.executeQuery();
			// On est censé récupérer un seul utilisateur

			utilisateur = getUtilisateur(utilisateur, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(utilisateur);
		return utilisateur;
	}

	private Utilisateur getUtilisateur(Utilisateur utilisateur, ResultSet rs) throws SQLException {
		if (rs.next()) {
			utilisateur.setNoUtilisateur(rs.getInt(1));
			utilisateur.setPseudo(rs.getString(2));
			utilisateur.setNom(rs.getString(3));
			utilisateur.setPrenom(rs.getString(4));
			utilisateur.setEmail(rs.getString(5));
			utilisateur.setTelephone(rs.getString(6));
			utilisateur.setRue(rs.getString(7));
			utilisateur.setCodePostal(rs.getString(8));
			utilisateur.setVille(rs.getString(9));
		} else
			utilisateur = null;
		return utilisateur;
	}

	public Utilisateur selectByEmail(String email) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			utilisateur = getUtilisateur(utilisateur, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public void deleteByEmail(String email, String motDePasse) {
	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        // Vérifier d'abord si l'utilisateur existe avec l'email fourni et le mot de passe correct
	        PreparedStatement checkStmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE email = ? AND mot_de_passe = ?");
	        checkStmt.setString(1, email);
	        checkStmt.setString(2, motDePasse);
	        ResultSet rs = checkStmt.executeQuery();

	        if (rs.next()) {
	            // L'utilisateur existe avec l'email fourni et le mot de passe est correct, supprimer l'utilisateur
	            PreparedStatement deleteStmt = cnx.prepareStatement("DELETE FROM UTILISATEURS WHERE email = ?");
	            deleteStmt.setString(1, email);
	            deleteStmt.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
