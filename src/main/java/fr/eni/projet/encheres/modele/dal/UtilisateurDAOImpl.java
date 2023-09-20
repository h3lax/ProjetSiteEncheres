package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import fr.eni.projet.encheres.modele.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO UTILISATEURS values (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
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
			while(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}

	@Override
	public int verifNouvelUtilisateur(String pseudo, String email) {
		int result = 3;
		try (Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE pseudo = ? or email = ?");
			stmt.setString(1, pseudo);
			stmt.setString(2, email);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				//pas de match trouvé
				result = 0;
			}else if (rs.getString("email").equals(email)) {
				//email existant
				result = 1;
			}else {
				//Pseudo déjà utilisé
				result = 2;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
