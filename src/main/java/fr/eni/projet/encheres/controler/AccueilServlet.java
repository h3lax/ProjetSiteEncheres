package fr.eni.projet.encheres.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.modele.bo.ArticleVendu;
import fr.eni.projet.encheres.modele.dal.ArticleVenduDAO;
import fr.eni.projet.encheres.modele.dal.DAOFactory;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
        try {
            List<ArticleVendu> listeEncheres = articleVenduDAO.listerEncheresEnCours();
            request.setAttribute("listeEncheres", listeEncheres);
            request.getRequestDispatcher("/accueil.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
         // TODO : faire la gestion des exceptions
        }
    }

}
