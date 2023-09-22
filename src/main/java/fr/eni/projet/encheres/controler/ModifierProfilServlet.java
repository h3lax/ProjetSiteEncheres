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
import fr.eni.projet.encheres.modele.dal.DAOFactory;
import fr.eni.projet.encheres.modele.dal.UtilisateurDAO;

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
		
		// Récupérer l'utilisateur en session !!!
		// HttpSession session = request.getSession();
		// Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		// ICI on concircuite tout pour tester
		Utilisateur utilisateur = new Utilisateur("pseudo", "nom", "prenom", "email@email.com", "telephone", "rue",
				"codePostal", "ville", "motDePasse");
		UtilisateurDAO u = DAOFactory.getUtilisateurDAO();
		utilisateur = u.creerUtilisateur(utilisateur);
		
		//On clone l'utilisateur pour n'appliquer les modification à l'objet utilisateur que si l'ensemble du process est validé
		Utilisateur utilisateurClone = utilisateur;
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
		
		if (action.equals("enregistrer")) {
			//Les vérifs + modif
			if (utilisateurManager.verifChampsRemplits(prenom)) utilisateurClone.setPrenom(prenom);
			if (utilisateurManager.verifChampsRemplits(telephone)) utilisateurClone.setTelephone(telephone);
			if (utilisateurManager.verifChampsRemplits(codePostal)) utilisateurClone.setCodePostal(codePostal);
			if (utilisateurManager.verifChampsRemplits(nom)) utilisateurClone.setNom(nom);
			if (utilisateurManager.verifChampsRemplits(rue)) utilisateurClone.setRue(rue);
			if (utilisateurManager.verifChampsRemplits(ville)) utilisateurClone.setVille(ville);
			// on vérifie si l'email ou le pseudo existe déjà
			boolean modifPseudo = utilisateurManager.verifChampsRemplits(pseudo);
			boolean modifEmail = utilisateurManager.verifChampsRemplits(email);
			String erreurIdentifiant = null;
			if (modifPseudo || modifEmail) {
				switch (utilisateurManager.verifNouvelUtilisateur(pseudo, email)){
					case 0 : 	if(modifPseudo) utilisateurClone.setPseudo(pseudo);
								if(modifEmail) utilisateurClone.setEmail(email);break;
					case 1 : erreurIdentifiant = "Il existe déjà un compte associé à cet eamil";
					case 2 : erreurIdentifiant = "Pseudo déjà utilisé";
					default : erreurIdentifiant = "Normalement ça ne peut pas arriver";
				}
			}
				//ici on vérifie chaque élément dans l'ordre pour ne effectuer de requete en BD inutile. On prend bien l'ID de l'utilisateur et pas du clone pour vérifier le mdp
			String erreurMdp = null;
			if (utilisateurManager.verifChampsRemplits(nouveauMotDePasse)) {
				if (utilisateurManager.verifConfirmation(nouveauMotDePasse, confirmation)) {
					if (utilisateurManager.connection(utilisateur.getPseudo(), motDePasseActuel) != null) utilisateurClone.setMotDePasse(nouveauMotDePasse);
					else {
						erreurMdp = "Vous avez entré un mauvais mot de passe";
					}
				}else {
					erreurMdp = "Les 2 mots de passe ne correspondent pas";
				}
			}
	
			//On vérifie s'il n'y a pas d'erreurs et on valide les modifs et les répercute sur la BD
			if (erreurIdentifiant == null && erreurMdp == null) {
				if (utilisateurManager.modifierUtilisateur(utilisateurClone)) utilisateur = utilisateurClone;
				//JE SAIS PAS SI LUTILISATEUR EN SESSION SACTUALISE TOUT SEUL OU SI JE DOIS LE FAIRE MAIS POUR LINSTANT JE LE FAIS PAS
				this.getServletContext().getRequestDispatcher("/mon-profil.jsp").forward(request, response);
			} else {
				request.setAttribute("erreurMdp", erreurMdp);
				request.setAttribute("erreurIdentifiant", erreurIdentifiant);
				this.getServletContext().getRequestDispatcher("/modifier-profil.jsp").forward(request, response);
			}
		}
		
		if(action.equals("supprimer")){
			System.out.println("IL FAUT SUPPRIMER LE COMPTE");
		}
		
	}

}
