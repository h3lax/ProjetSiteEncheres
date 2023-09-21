package fr.eni.projet.encheres.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bll.UtilisateurManager;
import fr.eni.projet.encheres.modele.bll.UtilisateurManagerImpl;
import fr.eni.projet.encheres.modele.bo.Utilisateur;

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/modifier-profil")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/modifier-profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String codePostal = request.getParameter("codePostal");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String confirmation = request.getParameter("confirmation");
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		
	}

}
