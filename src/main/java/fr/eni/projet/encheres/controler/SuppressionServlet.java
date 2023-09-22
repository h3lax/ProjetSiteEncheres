package fr.eni.projet.encheres.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bll.UtilisateurManager;
import fr.eni.projet.encheres.modele.bll.UtilisateurManagerImpl;

/**
 * Servlet implementation class SuppressionServlet
 */
@WebServlet("/suppression")
public class SuppressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Afficher le formulaire de suppression
		request.getRequestDispatcher("/suppression.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recup données
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");

		// suppr utilisateur avec deleteByMail
		utilisateurManager.deleteByEmail(email, motDePasse);

		
		request.setAttribute("confirmationMessage", "Votre compte a été supprimé avec succès !");

		// Rediriger vers la page de confirmation avec un message 
		request.getRequestDispatcher("/suppression.jsp").forward(request, response);
	}
}
