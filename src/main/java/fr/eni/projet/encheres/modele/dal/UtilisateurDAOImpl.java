package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import fr.eni.projet.encheres.modele.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO UTILISATEURS values (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			setUtilisateur(utilisateur, stmt);
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			while(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}

	public Utilisateur selectByIdentifiant(String pseudo, String email) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection()){
			
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
		return selectByIdentifiant( identifiant, identifiant);
	}

	public Utilisateur connection(String identifiant, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// On fait un select avec soit le pseudo soit l'identifiant MAIS AUSSI AVEC le bon mdp
			PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE (pseudo = ? OR email = ?)  AND mot_de_passe=? ");
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			pstmt.setString(3, motDePasse);
			ResultSet rs = pstmt.executeQuery();
			//On est censé récupérer un seul utilisateur
			
			utilisateur = getUtilisateur(utilisateur, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(utilisateur);
		return utilisateur;
	}
	
	@Override
	public int modifierUtilisateur(Utilisateur utilisateur) {
		int ligneModifie = 0;
		try (Connection cnx = ConnectionProvider.getConnection()){
			String requete = "UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			setUtilisateur(utilisateur, pstmt);
			pstmt.setInt(10, utilisateur.getNoUtilisateur());
			ligneModifie = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligneModifie;
	}
	
	@Override
	public int supprimerUtilisateur(int noUtilisateur) {
		int ligneSupprime = 0;
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement stmt = cnx.prepareStatement("DELETE FROM utilisateurs WHERE no_utilisateur = ?");
			stmt.setInt(1, noUtilisateur);
			ligneSupprime = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligneSupprime;
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
			utilisateur.setMotDePasse(rs.getString(10));
		} else utilisateur = null;
		return utilisateur;
	}
	
	private void setUtilisateur(Utilisateur utilisateur, PreparedStatement stmt) throws SQLException {
		stmt.setString(1, utilisateur.getPseudo());
		stmt.setString(2, utilisateur.getNom());
		stmt.setString(3, utilisateur.getPrenom());
		stmt.setString(4, utilisateur.getEmail());
		stmt.setString(5, utilisateur.getTelephone());
		stmt.setString(6, utilisateur.getRue());
		stmt.setString(7, utilisateur.getCodePostal());
		stmt.setString(8, utilisateur.getVille());
		stmt.setString(9, utilisateur.getMotDePasse());
	}

		
}
