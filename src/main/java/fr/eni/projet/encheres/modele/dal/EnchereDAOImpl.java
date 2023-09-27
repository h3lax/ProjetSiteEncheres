package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	
	
}
