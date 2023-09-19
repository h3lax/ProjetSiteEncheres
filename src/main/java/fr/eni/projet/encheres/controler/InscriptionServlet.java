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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String codePostal = request.getParameter("codePostal");
		String motDePasse = request.getParameter("motDePasse");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String confirmation = request.getParameter("confirmation");
		
		System.out.printf("%s %s %s %s %s %s %s %s %s %s \n", pseudo, prenom, telephone, codePostal, motDePasse, nom, email, rue, ville, confirmation);
		
		if (utilisateurManager.verifConfirmation(motDePasse, confirmation)) {
			Utilisateur utilisateur = utilisateurManager.creerUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			request.setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher("/inscription-reussie.jsp").forward(request, response);
			
		}else {
			String erreurConfirmation = "La confirmation de votre mot de passe est différente de votre mot de passe";
			request.setAttribute("erreurConfirmation", erreurConfirmation);
			this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
		}
		
	}

}
