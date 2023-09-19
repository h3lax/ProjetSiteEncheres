package fr.eni.projet.encheres.modele.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	private static DataSource dataSource;
	
	static{
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}

}
