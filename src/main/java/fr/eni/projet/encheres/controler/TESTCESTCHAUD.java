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
 * Servlet implementation class TESTCESTCHAUD
 */
@WebServlet("/TESTCESTCHAUD")
public class TESTCESTCHAUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = utilisateurManager.selectByIndentifiant("Test1");
		utilisateur.setCredit(200);
		int montantEnchere = 150;
		System.out.println(utilisateur);
		if (utilisateurManager.paiement(utilisateur, montantEnchere)) System.out.println("ça marche");
		else System.out.println("ça marche pas");;
		System.out.println(utilisateur);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
