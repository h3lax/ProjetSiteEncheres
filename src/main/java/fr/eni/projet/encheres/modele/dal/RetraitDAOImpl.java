package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.encheres.modele.bo.Retrait;

public class RetraitDAOImpl implements RetraitDAO {
	
	private final String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";

	@Override
	public void insert(Retrait retrait) {
	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        PreparedStatement stmt = cnx.prepareStatement(INSERT);
	        stmt.setInt(1, retrait.getNoArticle());
	        stmt.setString(2, retrait.getRue());
	        stmt.setString(3, retrait.getCodePostal());
	        stmt.setString(4, retrait.getVille());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // TODO : faire la gestion des exceptions
	    }
	}

}
