package fr.eni.trocEncheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bll.CategorieManager;
import fr.eni.trocEncheres.bll.EnchereManager;
import fr.eni.trocEncheres.bll.VenteManager;
import fr.eni.trocEncheres.bo.Categorie;
import fr.eni.trocEncheres.bo.Enchere;

/**
 * Servlet implementation class ServletAccueilUtilisateur
 * @author damien
 */
@WebServlet("/ServletListeEncheres")
public class ServletListeEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cMgr;
		EnchereManager eMgr;
		VenteManager vMgr;
		try {
			// récupère les catégories enregistrées en base de données pour les afficher sous la forme d'un select dans la JSP
			cMgr = CategorieManager.getInstance();
			request.setAttribute("categories", cMgr.getCategories());
			//récupère les ventes en cours pour les afficher dans l'écran d'accueil
			vMgr = VenteManager.getInstance();
			request.setAttribute("annonces", vMgr.getVentes());
		} catch (BusinessException e) {
			request.setAttribute("listeErreurs", e.getListeCodesErreur());
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
