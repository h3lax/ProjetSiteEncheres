package fr.eni.projet.encheres.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.dal.ConnectionProvider;
/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/connection")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String identifiant = request.getParameter("id");
		System.out.println(identifiant);

		String motDePasse = request.getParameter("mdp");
		System.out.println(motDePasse);

		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(
						"SELECT pseudo, email, mot_de_passe FROM utilisateurs WHERE pseudo = ? OR email = ?  OR mot_de_passe=? ")) {
			System.out.println("ca fonctionne");
			String pseudoOuEmail = identifiant;
			String verifMdp = motDePasse;
			pstmt.setString(1, pseudoOuEmail);
			pstmt.setString(2, pseudoOuEmail);
			pstmt.setString(3, verifMdp);
			
			
			System.out.println("ca fonctionne toujours");
			try (ResultSet resultSet = pstmt.executeQuery()) {
			    if (resultSet.next()) {
			        // Utilisateur trouvé dans la base de données
			        String pseudoBDD = resultSet.getString("pseudo");
			        String emailBDD = resultSet.getString("email");
			        String motDePasseBDD = resultSet.getString("mot_de_passe");

			        // Comparaison avec les valeurs saisies 
			        if ((pseudoOuEmail.equals(pseudoBDD) && verifMdp.equals(motDePasseBDD))
			            || (pseudoOuEmail.equals(emailBDD) && verifMdp.equals(motDePasseBDD))) {

			            // L'utilisateur existe dans la base de données avec un bon mot de passe
			            // Redirigez vers la page d'accueil, a créer
			            this.getServletContext().getRequestDispatcher("/acceuil.jsp").forward(request, response);
			            System.out.println("ok");
			        } else {
			            // Erreur de saisie
			            this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
			            System.out.println("Erreur saisie");
			            
			          
			        }
			    } else {
			        // pas d'utilisateur correspondant trouvé dans la base de données
			        
			        this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
			        System.out.println("Redirection vers la page d'inscription");
			    }
			}

		} catch (SQLException e) {
			e.printStackTrace();

			this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
		}

	}
}
